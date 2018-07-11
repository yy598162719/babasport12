package cn.itcast;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TbTest {
    @Autowired
    private TestTbService testTbService;
    @Test
    public void testAdd() throws Exception{
        TestTb testTb = new TestTb();
        testTb.setName("李威君");
        testTb.setBirthday(new Date());
        testTbService.add(testTb);
    }
}
