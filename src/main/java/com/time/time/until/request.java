package com.time.time.until;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class request {
private  String msg;
private String code;
private List<Object> result;
private HashMap<String,Object> map;
}
