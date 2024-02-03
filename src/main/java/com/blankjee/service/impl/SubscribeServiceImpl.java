package com.blankjee.service.impl;

import com.blankjee.dao.SubscribeRepository;
import com.blankjee.model.Subscribe;
import com.blankjee.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private SubscribeRepository subscribeRepository;

    @Transactional
    @Override
    public Subscribe saveSubScribe(Subscribe subscribe) {
        return  subscribeRepository.save(subscribe);
    }
}
