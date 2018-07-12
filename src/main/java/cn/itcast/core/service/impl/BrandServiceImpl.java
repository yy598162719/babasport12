package cn.itcast.core.service.impl;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.dao.product.BrandDao;
import cn.itcast.core.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 事务层,逻辑开发层 实现类
 *
 * @author lx
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    @Transactional(readOnly = true)
    public Pagination getBrandListWithPage(Brand brand) {

        //1起始页的页号 2每页数 3总记录数
        Pagination pagination = new Pagination(brand.getPageNo(), brand.getPageSize(), brandDao.getBrandCount(brand));

        //Brand集合
        pagination.setList(brandDao.getBrandListWithPage(brand));

        return pagination;
    }

    /**
     * 保存品牌
     *
     * @param brand
     */
    @Override
    public Integer addBrand(Brand brand) {
        // 保存数据
        return brandDao.addBrand(brand);
    }

    /**
     * 删除品牌
     *
     * @param id
     */
    @Override
    public void deleteBrandByKey(Integer id) {
        brandDao.deleteBrandByKey(id);
    }

    @Override
    public void deleteBrandByKeys(Integer[] ids) {
        brandDao.deleteBrandByKeys(ids);
    }

    @Override
    public void updateBrandByKey(Brand brand) {
        brandDao.updateBrandByKey(brand);
    }

    @Override
    public Brand getBrandByKey(Integer id) {
        return brandDao.getBrandByKey(id);
    }
}