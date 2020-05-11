package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author LBZ
 * @create 2020/5/4 - 21:58
 */
@Getter
@Setter
public class TestVo {

    //字符串
    @NotBlank
    private String msg;

    //判断对象
    @NotNull(message = "id不可以为空")
    @Max(value = 10, message = "id不能大于10")
    @Min(value = 0, message = "id至少大于等于0")
    private String id;

    //判断数组、List
    //@NotEmpty
    private List<String> str;
}
