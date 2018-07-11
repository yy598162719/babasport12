package cn.itcast.core.controller.admin;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌管理
 *
 * @author lx
 */
@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    //品牌列表页面
    @RequestMapping(value = "/brand/list.do")
    public String list(String name, Integer isDisplay, Integer pageNo, ModelMap model) {

        //参数
        StringBuilder params = new StringBuilder();

        Brand brand = new Brand();
        //判断传进来的名称是否为Null并且还要判断 是否为空串   blank  ""  "   "   emtpy  ""   "  "
        if (StringUtils.isNotBlank(name)) {
            brand.setName(name);
            params.append("name=").append(name);
        }
        if(null!=isDisplay){
            brand.setIsDisplay(isDisplay);
            params.append("&").append("isDisplay=").append(isDisplay);
        }else{
            brand.setIsDisplay(1);
            params.append("&").append("isDisplay=").append(1);
        }

        //如果页号为null 或小于1  置为1
        //页号
        brand.setPageNo(Pagination.cpn(pageNo));
      //每页数
        brand.setPageSize(5);
        //分页对象
        Pagination pagination = brandService.getBrandListWithPage(brand);

       //分页展示
        String url = "/brand/list.do";
        pagination.pageView(url, params.toString());

        model.addAttribute("pagination", pagination);//request.setAttribute
        model.addAttribute("name", name);//request.setAttribute
        model.addAttribute("isDisplay", isDisplay);//request.setAttribute

        return "brand/list";
    }
}