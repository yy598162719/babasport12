package cn.itcast.core.bean.product;

import lombok.Data;

import java.io.Serializable;

/**
 * 品牌对象
 * @author lixu
 * @Date [2014-3-28 下午04:38:53]
 */

public class Brand implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private String imgUrl;
    private Integer sort;
    private Integer isDisplay;

    //页号
    private Integer pageNo=1;
    //开始行
    private Integer startRow;
    //每页数
    private Integer pageSize=10;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sort=" + sort +
                ", isDisplay=" + isDisplay +
                ", pageNo=" + pageNo +
                ", startRow=" + startRow +
                ", pageSize=" + pageSize +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Integer isDisplay) {
        this.isDisplay = isDisplay;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //计算一次开始行
        this.startRow=(pageNo-1)*pageSize;
        this.pageNo = pageNo;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        //计算一次开始行
        this.startRow=(pageNo-1)*pageSize;
        this.pageSize = pageSize;
    }
}