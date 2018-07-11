package cn.itcast.core.controller.admin;

import cn.itcast.core.bean.TestTb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class CenterController {
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
