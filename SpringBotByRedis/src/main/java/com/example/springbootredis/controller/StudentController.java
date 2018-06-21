//package com.example.springbootredis.controller;
//
//import com.example.springbootredis.entity.Student;
//import com.example.springbootredis.service.StudentService;
//import com.example.springbootredis.service.redis.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@EnableAutoConfiguration
//public class StudentController {
//
//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private StudentService studentService;
//
//
//    /**简单查询*/
//    @RequestMapping("/getInfo")
//    public List<Student> getInfo(){
//        return  studentService.getInfo();
//    }
//
//    /**将值赋入Redis中*/
//    @RequestMapping("/pushStuInfo")
//    public void pushStuInfo(){
//        List<Student> list = studentService.getInfo();
//        List<Student> resList = new ArrayList<>();
//        for(Student stu : list){
//            if("108".equals(stu.getSno())){
//                System.out.println("有值"+stu.getSno());
//                Student var = new Student();
//                var.setSno(stu.getSno());
//                var.setSname(stu.getSname());
//                var.setSsex(stu.getSsex());
//                var.setSbirthday(stu.getSbirthday());
//                resList.add(var);
////                redisService.set("sno",stu.getSno());
////                System.out.println("redis--sno:"+redisService.get("sno"));
//            }
//        }
//        //把值存到Redis中
//        redisService.set("stuList",resList);
//    }
//
//    /**获取Redis中的值*/
//    @RequestMapping("/getStuInfo")
//    public Object getStuInfo(String key){
//        for (Student stu : (List<Student>)redisService.get(key)) {
//            System.out.println(stu.getSno()+"\t"+stu.getSname());
//        }
//
//        return redisService.get(key);
//    }
//
//}
