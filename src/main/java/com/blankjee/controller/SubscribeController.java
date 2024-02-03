package com.blankjee.controller;

import com.blankjee.model.Subscribe;
import com.blankjee.service.BlogService;
import com.blankjee.service.SubscribeService;
import com.blankjee.service.TagService;
import com.blankjee.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @PostMapping("/subscribe")
    public String post(@RequestParam String query, RedirectAttributes attributes,
                       @PageableDefault(size = 5, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        Subscribe subscribe = new Subscribe();
        subscribe.setEmail(query);
        subscribe.setCreateTime(new Date());
        Subscribe t = subscribeService.saveSubScribe(subscribe);
        if (t == null ) {
            attributes.addFlashAttribute("message","Đăng ký thất bại");
        } else {
            attributes.addFlashAttribute("message", "Đăng ký thành công");
        }
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        return "search";
    }
}
