package com.mmall.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

//将字符串解析成List<Integer>结构
public class StringUtil {

    public static List<Integer> splitToListInt(String str) {
        //"1,2,3,4,, ,"可以转化成"1234"
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        return strList.stream().map(strItem -> Integer.parseInt(strItem)).collect(Collectors.toList());
    }
}
