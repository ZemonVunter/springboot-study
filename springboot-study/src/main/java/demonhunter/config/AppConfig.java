package demonhunter.config;

import demonhunter.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean
    public Map<Integer,Integer> test1(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,100);
        map.put(2,100);
        map.put(3,100);
        return map;

    }
    @Bean
    public Map<Integer,Integer> test2(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,200);
        map.put(2,200);
        map.put(3,200);
        return map;

    }
    @Bean
    public User user1(){
        User user=new User();
        user.setPassWord("123456");
        user.setUserName("张三三");
        return user;
    }
    @Bean
    public User user2(){
        User user=new User();
        user.setPassWord("123456");
        user.setUserName("王五五");
        return user;
    }
}
