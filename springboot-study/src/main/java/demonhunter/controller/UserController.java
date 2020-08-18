package demonhunter.controller;

import demonhunter.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller//当前类注册实例到容器中，并指定为web请求响应处理
@RequestMapping("/user")//可以定义请求相关的配置，如路径，请求方法等
public class UserController {
    // @Autowired@Resource区别
    //@Autowire属于spring提供的注解，@Resource是JDK提供的资源，且只提供了规范，没有提供具体实现
    @Resource
    private Map<Integer, Integer> test1;


//    @Autowired
//    @Qualifier("user1")
//    private User user;//变量名和bean的名称不一致@Autowired要搭配@Qualifier指定bean的名称

    @Resource(name = "user1")
    private User user;

    public UserController() {
    }

    @RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object login1(){
        return user;

    }

    @RequestMapping("/login1")
    @ResponseBody//

    public Object login(){
        Map<String,String> map=new HashMap<>();
        map.put("man","博哥");
        map.put("tea","汤神");
        return  map;

    }
    @RequestMapping("/m")
    public String m(){
        return  "/main.html";
    }

   @RequestMapping("/l1")
   public String l1(){

        return "forward:/user/login";
   }
    @RequestMapping("/l2")
    public String l2(){

        return "redirect:/user/login";
    }
    @RequestMapping("/test/{key}")
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k){
        System.out.println("=========================="+test1.get(k));
        return test1;
    }
    @RequestMapping(value = "/test2",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object test2(@RequestParam("k1") String ksss,//写全,通过注解值为key查找请求
    @RequestParam String k2, //省略注解值，默认变量名为key
   String k3//最省略默认就@Requestparam注解
    ){
        System.out.println("=========================="+ksss+","+k2+","+k3);
        return test1;
    }
    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user){
        System.out.println(user);
        return test1;
    }
    @RequestMapping("/test4")
    @ResponseBody
    public Object test4(User user){

        return null;
    }
    @RequestMapping("/test5")
    @ResponseBody
    public Object test5(User user){

        return "ok";//返回字符串，响应体不是返回appllication/jason格式，而是text/plain字符串内容
    }
//    @RequestMapping("/test6")
//    @ResponseBody
    //http请求是基于Servlet的，spring已经生成了request和response对象，可以直接在参数中使用
//    public Object test6(HttpServletRequest req, HttpServletResponse res){
//        System.out.println("=================="+req.getParameter("username")+","res.getParameter("password"));
//        return null;
//    }
    @RequestMapping("/test8")
    @ResponseBody
    public Object test8(){
        throw new RuntimeException("数据库报错");
    }
}



