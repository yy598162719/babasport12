package cn.itcast.core.dao;

import cn.itcast.core.bean.TestTb;
import org.springframework.stereotype.Component;

@Component
public interface TestTbDao {
    //测试添加
    void addTestTb(TestTb testTb);
}
