package cn.itcast.core.service.impl;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.dao.TestTbDao;
import cn.itcast.core.service.TestTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class TestTbServiceImpl implements TestTbService {
    @Resource
    private TestTbDao testTbDao;
    @Override
    public void add(TestTb tb) {
        testTbDao.addTestTb(tb);
    }
}
