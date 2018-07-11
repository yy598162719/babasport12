package cn.itcast.core.controller.admin;

import cn.itcast.core.bean.TestTb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/control")
public class CenterController {
    @RequestMapping("/test/springmvc.do")
    public String testSpringmvc(TestTb testTb, Date birthday) {
        System.out.println(testTb);
        return "success";
    }

//    //局部注册日期格式
//    @InitBinder
//    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat,false));//允许为空
//    }

    /**
     * 跳转入口页面
     *
     * @return
     */
    @RequestMapping("/index.do")
    public String index() {
        return "index";
    }

    /**
     * 跳转头页面
     *
     * @return
     */
    @RequestMapping("/top.do")
    public String top() {
        return "top";
    }

    /**
     * 跳转身体页面
     *
     * @return
     */
    @RequestMapping("/main.do")
    public String main() {
        return "main";
    }

    /**
     * 跳转左体页面
     *
     * @return
     */
    @RequestMapping("/left.do")
    public String left() {
        return "left";
    }

    /**
     * 跳转右体页面
     *
     * @return
     */
    @RequestMapping("/right.do")
    public String right() {
        return "right";
    }
}
