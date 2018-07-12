package cn.itcast.core.controller.admin;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import common.ResponseUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static common.Constants.IMAGE_URL;

/**
 * 上传图片、商品、品牌、商品介绍
 */
@Controller
public class UploadController {
    /**
     * 图片上传
     * @param pic
     */
    @RequestMapping("/upload/uploadPic.do")
    //required=false表示不上传就报错
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) {

        //图片名称生成策略
       DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
       //图片名称的一部分
        String format = dateFormat.format(new Date());
        //随机三位数
        Random random = new Random();
        for (int i = 0; i <3 ; i++) {
            format+=random.nextInt(10);
        }
        //获取文件扩展名的专用方法
        String extension = FilenameUtils.getExtension(pic.getOriginalFilename());

        //实例化一个jersey
        Client client = new Client();
        //保存数据库的路径和名字，要发给添加页面
        String pathSql = format + "." + extension;
        //另一个服务器的请求路径是？
        String url = IMAGE_URL+format+"."+extension;
        //设置请求路径
        WebResource resource = client.resource(url);
        // 发送开始
        try {
            resource.put(String.class, pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    //返回两个路径
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url",url);
        jsonObject.put("path",pathSql);

        ResponseUtils.renderJson(response,jsonObject.toString());

    }
}
