package com.time.time.model;

import lombok.Data;

@Data
public class Record {

    private String id;
    private String taskCode;
    private String taskName;
    private String greatTime;
    private Integer time;
    private String userCode;
    private String userName;
    private String taskNews;
    private Integer isFinish;
}
