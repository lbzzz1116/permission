package com.mmall.beans;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

//分页的类，分页参数
public class PageQuery {

    @Getter
    @Setter
    @Min(value = 1, message = "当前页码不合法")
    private int pageNo = 1;

    @Getter
    @Setter
    @Min(value = 1, message = "每页展示数量不合法")
    private int pageSize = 10;

    //偏移量
    @Setter
    private int offset;

    //算出分页偏移量
    public int getOffset() {
        return (pageNo - 1) * pageSize;
    }
}
