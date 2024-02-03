package com.blankjee.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_subscribe")
public class Subscribe {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
