package com.mmall.dto;

import com.mmall.model.SysAcl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@ToString
//适配
public class AclDto extends SysAcl {

    // （角色）是否要默认选中权限
    private boolean checked = false;

    // 用户是否有权限操作
    private boolean hasAcl = false;

    public static AclDto adapt(SysAcl acl) {
        AclDto dto = new AclDto();
        //复制属性
        BeanUtils.copyProperties(acl, dto);
        return dto;
    }
}
