package cn.itcast.core.controller;

import cn.itcast.core.bean.TestTb;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ProductController {
    @RequestMapping("/test/springmvc.do")
    public String testSpringmvc(TestTb testTb, Date birthday){
        System.out.println(testTb);
        return "success";
    }

//    //局部注册日期格式
//    @InitBinder
//    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));//允许为空
//    }
}
