package com.cqeec.vote.controller;

import com.cqeec.vote.domain.Img;
import com.cqeec.vote.domain.JsonData;
import com.cqeec.vote.domain.User;
import com.cqeec.vote.mapper.ImgMapper;
import com.cqeec.vote.mapper.UserMapper;
import com.cqeec.vote.service.ImgService;
import com.cqeec.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("login")
@SpringBootApplication
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})/*不加载数据库*/
public class Logincontroller {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    //测试模板引擎
    @RequestMapping("t1")
    public Object jj(){
        return "1";
    }

    //测试数据库
    @ResponseBody
    @RequestMapping("t2")
    public Object yy(){return userMapper.finAll(new User());}

    @GetMapping(value="/v1/page_user1")
    public Object pageUser(HttpServletRequest request,ModelMap map,String email,String pwd){/*http://localhost:8080/v1/page_user1?from=1&size=2*/
        User user=new User();
        user.setEmail(email);
        user.setPwd(pwd);
        userService.login(user);
        boolean re=userService.login(user);
        if (re){
            map.put("ti",imgService.in());
            System.out.println(imgService.in().get(0).getNum());
            HttpSession session=request.getSession();
            session.setAttribute("email",email);
            return "2";
        }else {
            return "1";
        }
//        try {
//            if (pwd.equals(userMapper.finAll1(new User(0,null,email,null,null)).get("pwd"))){
//
//                map.put("ti",userMapper.f(new Img()));
//                HttpSession session=request.getSession();
//                session.setAttribute("email",email);
//                return "2";
//            }else {
//                return "1";
//            }
//        }catch (NullPointerException e){
//            return "1";
//        }


    }
    @GetMapping("z1")
    public Object jj1(){
        return "zhuche";
    }
    @GetMapping("zc")
    public Object jj(User user){
        if (userMapper.finAll1(user)!=null){
            return new JsonData(1,"邮箱已存在");
        }
        if(userMapper.insert(user)!=0){
            return "1";
        }else {
            return new JsonData(2,"注册失败");
        }

    }
    @Value("${nn}")
    private String mm;//把地址放到配置文件里在这里把它去出来放到mm里
    @Autowired
    private ImgService imgService;
    //private static final String filePath="jetbrains://idea/navigate/reference?project=vote&fqn=static.upload/";//把上传的文件保存到什么地方路径最后要加个斜杠这是用到硬编码
    @PostMapping("upload")
    @ResponseBody
    public Object upload1(@RequestParam("file") MultipartFile file,HttpServletRequest request,ModelMap map) throws IOException {
//        String name=reput.getParameter("name");
//        System.out.println("用户名"+name);
        //获取文件名
        String fileName=file.getOriginalFilename();
        System.out.println("上传的文件名"+fileName);
        //获取文件的后缀名，比如图片的jpeg。png
        String suffxName=fileName.substring(fileName.lastIndexOf("."));
//        //文件上传后的路径
        fileName= UUID.randomUUID()+suffxName;//UUID.randomUUID()随机生成id文件名+suffxName加上后缀
        System.out.println("转换后的名称"+fileName);
        File dest=new File(mm+fileName);//创建一个文件名为fileName的文件将他放filePath这个路径
        System.out.println(mm);
        try{
            file.transferTo(dest);//把文件fileName保存到dest路径
            Img img=new Img();
            img.setImg_addr(fileName);
            HttpSession session=request.getSession();
            img.setAuthor((String) session.getAttribute("email"));
            imgService.inertImg(img);
            return 1;
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
       return 0;

    }

    @Autowired
    private ImgMapper imgMapper;
    @RequestMapping("jj")
    @ResponseBody
    public Object getImgMapper() {
        return imgMapper.ff();
    }
}
