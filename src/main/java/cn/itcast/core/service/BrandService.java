package cn.itcast.core.service;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;

/**
 * 事务层,逻辑开发层 接口
 * @author lx
 *
 */
public interface BrandService {
    Pagination getBrandListWithPage(Brand brand);

    Integer addBrand(Brand brand);

    void deleteBrandByKey(Integer id);

    void deleteBrandByKeys(Integer[] ids);

    void updateBrandByKey(Brand brand);

    Brand getBrandByKey(Integer id);
}