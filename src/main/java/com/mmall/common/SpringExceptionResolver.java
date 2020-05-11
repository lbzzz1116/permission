package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接口请求全局异常处理
 * @author LBZ
 * @create 2020/5/4 - 16:36
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        //取出当前返回的url
        String url = request.getRequestURL().toString();
        //存储处理完后的结果数据，以及显示该数据的视图
        ModelAndView mv;
        //定义默认异常
        String defaultMsg = "System error";

        //页面请求.page 、数据请求.json 异常
        //这里我们要求项目中所有请求json数据，都使用.json结尾
        if (url.endsWith(".json")){
            if (ex instanceof PermissionException || ex instanceof ParamException){
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            } else {
                log.error("unknown json exception,url:" + url, ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",result.toMap());
            }
        } else if (url.endsWith(".page")) {//这里我们要求项目中所有请求page页面，都使用.page结尾
            log.error("unknown page exception,url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        } else {//全局处理，既不是json也不是page
            log.error("unknown exception,url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }

        return mv;
    }
}
