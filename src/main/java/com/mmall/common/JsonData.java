package com.mmall.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 后台收到前台的请求，页面请求或者数据请求，页面直接返回
 * 数据请求除了需要返回数据，还要通过返回值告诉它当前请求处理方式（正常、异常），通常通过json返回
 * @author LBZ
 * @create 2020/5/4 - 16:26
 */
//定义json返回的结构
@Getter
@Setter
public class JsonData {

    //返回结果，成功true、失败false
    private boolean ret;
    //异常时给的msg
    private String msg;
    //正常时返回的数据
    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData success(Object object, String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public  static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String,Object> toMap() {
        HashMap<String, Object> result = new HashMap<String ,Object>();
        result.put("ret", ret);
        result.put("msg", msg);
        result.put("data", data);
        return result;
    }



}
