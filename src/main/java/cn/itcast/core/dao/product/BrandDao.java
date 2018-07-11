package cn.itcast.core.dao.product;

import cn.itcast.core.bean.product.Brand;

import java.util.List;

/**
 * 数据交互层
 *
 * @author lx
 */
public interface BrandDao {
    public List<Brand> getBrandListWithPage(Brand brand);

    public int getBrandCount(Brand brand);
}