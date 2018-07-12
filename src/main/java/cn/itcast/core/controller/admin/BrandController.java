package cn.itcast.core.controller.admin;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 品牌管理
 *
 * @author lx
 */
@Controller
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 品牌列表页面
     *
     * @param name
     * @param isDisplay
     * @param pageNo
     * @param model
     * @return
     */
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
        if (null != isDisplay) {
            brand.setIsDisplay(isDisplay);
            params.append("&").append("isDisplay=").append(isDisplay);
        } else {
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

    /**
     * 跳转至品牌添加页面
     */
    @RequestMapping(value = "/brand/toAdd.do")
    public String toAdd() {
        return "brand/add";
    }

    /**
     * 添加品牌操作
     */
    @RequestMapping(value = "/brand/add.do")
    public String add(Brand brand, HttpServletResponse response, HttpServletRequest request, ModelMap modelMap) {
        //保存
        brandService.addBrand(brand);
        //重定向到品牌列表页面
        return "redirect:/brand/list.do";
    }

    /**
     * 根据主键删除一个
     *
     * @param id
     * @return
     */
    @RequestMapping("/brand/delete.do")
    public String delete(Integer id, String name, Integer isDisplay, ModelMap modelMap) {
        if (StringUtils.isNotBlank(name)) {
            modelMap.addAttribute("name", name);
        }
        if (null != isDisplay) {
            modelMap.addAttribute("isDisplay", isDisplay);
        }
        brandService.deleteBrandByKey(id);
        return "redirect:/brand/list.do";
    }


    /**
     * 根据主键删除多个
     *
     * @param ids
     * @return
     */
    @RequestMapping("/brand/deletes.do")
    public String deletes(Integer[] ids, String name, Integer isDisplay, ModelMap modelMap) {
        if (StringUtils.isNotBlank(name)) {
            modelMap.addAttribute("name", name);
        }
        if (null != isDisplay) {
            modelMap.addAttribute("isDisplay", isDisplay);
        }
        brandService.deleteBrandByKeys(ids);
        return "redirect:/brand/list.do";
    }

    /**
     * 去修改页面
     */
    @RequestMapping(value = "/brand/toEdit.do")
    public String toEdit(Integer id, ModelMap modelMap) {
        Brand brand = brandService.getBrandByKey(id);
        modelMap.addAttribute("brand",brand);
        return "brand/edit";
    }

    /**
     * 进行修改
     */
    @RequestMapping(value = "/brand/edit.do")
    public String edit(Brand brand, ModelMap modelMap) {
        brandService.updateBrandByKey(brand);
        return "redirect:/brand/list.do";
    }
}