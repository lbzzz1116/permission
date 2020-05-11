package com.mmall.beans;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//封装分页List返回的结果
@Getter
@Setter
@ToString
@Builder
//Builder模式简化get set方法, @Builder注解 可以很方便的使用构造模式,设计模式之建造者模式
public class PageResult<T> {

    private List<T> data = Lists.newArrayList();

    private int total = 0;
}
