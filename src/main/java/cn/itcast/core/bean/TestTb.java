package cn.itcast.core.bean;

import lombok.Data;
import java.util.Date;

@Data
public class TestTb {
    private Integer id;
    private String name;
    private Date birthday;
}