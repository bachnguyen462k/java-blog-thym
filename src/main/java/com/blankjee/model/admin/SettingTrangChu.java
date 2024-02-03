package com.blankjee.model.admin;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "s_trang_chu")
public class SettingTrangChu {
    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
}
