package com.example.springdemo.controller;


import com.example.springdemo.common.ConfSystemConstants;
import com.example.springdemo.ectity.TestBean;
import com.example.springdemo.ectity.User;
import com.example.springdemo.service.UserService;
import com.example.springdemo.util.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
@Component
@EnableAutoConfiguration
@RequestMapping(value = "/boot")
public class ReStartController extends BaseController {
    Logger logger =LoggerFactory.getLogger(ReStartController.class);
    private static final int PIC_H=100;
    private static final int PIC_W=40;
    @Autowired
    private UserService userService;
   /* @RequestMapping(value = "/findAll")
    public List<User> findAll(){
        List<User> userList = userService.findAllUser();
        return userList;
    }*/

    @RequestMapping(value = "/testPage.html")
    public ModelAndView testPage(){
        ModelAndView result = new ModelAndView("test1");

        return result;
    }
    /**
     * xzh
     * 测试
     * @return
     */
   /* @RequestMapping(value = "/tests.html")
    public ModelAndView tests(){
        ModelAndView modelAndView = new ModelAndView("indexs");
        List<User> userList = userDao.findAllUser();
        modelAndView.addObject("userList",userList);
        String key = "FxvHk3uCK2Ii";
        String json = "{\"userID\":\"340602199105060013\"}";
        String enStr = DESUtil.encrypt(json,key);
        System.err.println(enStr);
        return  modelAndView;
    }*/
    /**
     * xzh
     * 首页
     * @return
     */
    @RequestMapping(value = "/test/testindex.html")
    public ModelAndView test(HttpSession session,
                             @RequestParam(required = false,defaultValue = "1") String pageNum,
                             @RequestParam(required = false,defaultValue = "20") String pageSize){
        ModelAndView modelAndView = new ModelAndView("testindex");



        /*if(jedis.exists("userList").equals(true)){
            jedis.del("userList");
        }*/
        List<User> userList = userService.findAllUser(new PageUtil(pageNum,pageSize));
        modelAndView.addObject("userList",userList);
        /*String userLists =JSON.toJSONString(userList);
        boolean falg = ;
        System.err.println(falg);

        jedis.set("userList",userLists);
        String jsonUserList = jedis.get("userList");*/
        /*Jedis jedis = new Jedis(ConfSystemConstants.REDISHOST,Integer.valueOf(ConfSystemConstants.REDISPORT));
        String jsonUserList = jedis.get("userList");
        List<User> list = JSONArray.parseArray(jsonUserList,User.class);*/
        /*modelAndView.addObject("userList",list);*/
        /*List<User> list = JSONArray.parseArray(jsonUserList,User.class);
        for (int i =0; i< list.size();i++){
            System.err.println(list.get(i).getUname()+"-"+list.get(i).getUimg());
        }*/

        /*RedisUtil.set("test","Hello,XZH");
        System.err.println(RedisUtil.get("test"));*/
        /*String key = "FxvHk3uCK2Ii";
        String json = "{\"userID\":\"340602199105060013\"}";*/
        /*logger.info("开始设置session");
        session.setAttribute("key",key);*/
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH;mm:ss");
        Date date = new Date(session.getCreationTime());
        String format = sdf.format(date);
        System.out.println("session创建时间"+format);*/
        /*String enStr = DESUtil.encrypt(json,key);*/
       /* Map<String ,String> map = new HashMap<String, String>();
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        setPageInfo(modelAndView,userList,"/boot/test/testindex.html",map);*/
       /* session.setMaxInactiveInterval(5);//session过期时间为秒，不是毫秒！！！*/
       /* System.err.println(enStr);*/
        return  modelAndView;

    }
    /**
     * 进入添加页面
     * @return
     */
    @RequestMapping(value = "/test/insertUser.html")
    public ModelAndView insertUser(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("testInsertUser");
       /* System.err.println("拿到session中设置的值："+session.getAttribute("key"));*/
       /* List<User> list = (List<User>) session.getAttribute("key");
        for (int i = 0;i<list.size();i++){
            System.err.println(list.get(i));
        }*/
        /*System.err.println(list.get(0).getUid());
        System.err.println(list.get(0).getUimg());*/
       /* String[] valueNames = session.getValueNames();
        for (int i=0;i<valueNames.length;i++){
            System.err.println(valueNames[i]);
        }*/
       /* System.err.println("设置session过期时间为5秒");*/

        /*System.err.println("5秒之后再次去拿session中设置的值："+session.getAttribute("key"));*/
        /*System.err.println("移除session中的值");
        logger.info("logger优先级");
        session.removeAttribute("key");
        System.err.println("再次去拿session中设置的值："+session.getAttribute("key"));*/
        return modelAndView;
    }
    /**
     * 进入修改页面
     * @return
     */
    @RequestMapping(value = "/test/updateUser.html")
    public ModelAndView findUserById(@RequestParam("uid") String id){
        ModelAndView modelAndView = new ModelAndView("testInsertUser");
        User user = userService.findUserById(id);
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping(value = "/test/updateUsers.html")
    public String updateUser(HttpServletRequest request){
        String uid = request.getParameter("uid");
        String uimg = request.getParameter("uimgs");
        String uname = request.getParameter("uname");
        String unickname = request.getParameter("unickname");
        String upassword = request.getParameter("upassword");
        User user = new User();
        user.setUid(uid);
        user.setUimg(uimg);
        user.setUname(uname);
        user.setUnickname(unickname);
        user.setUpassword(upassword);
        userService.updateUser(user);

        return "redirect:/boot/test/testindex.html";
    }
    @RequestMapping(value = "/test/addUser.html",method = RequestMethod.POST)
    public String addUser(HttpServletRequest request,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("testInsertUser");
        User user = new User();
        user.setUid(UUIDUtil.uuid());

        String uimg = request.getParameter("uimgs");
        System.err.println(uimg);
        String uname = request.getParameter("uname");
        System.err.println(uname);
        String unickname = request.getParameter("unickname");
        System.err.println(unickname);
        String upassword = request.getParameter("upassword");
        user.setUimg(uimg);
        user.setUname(uname);
        user.setUnickname(unickname);
        user.setUpassword(upassword);
        userService.insertUser(user);
        Jedis jedis = new Jedis(ConfSystemConstants.REDISHOST,Integer.valueOf(ConfSystemConstants.REDISPORT));
        /*jedis.rpush("userlists",user.toString());*/
        /*String code = request.getParameter("code");
        Object code_rand = session.getAttribute("code_rand");
        if(!code.equals(code_rand)){
            modelAndView.addObject("error","验证码错误");
            return "testInsertUser";
        }*/
        return "redirect:/boot/test/testindex.html";
    }
    /**
     * 根据id删除
     */
    @ResponseBody
    @RequestMapping(value = "/test/delete.html",method = RequestMethod.POST)
    public Map<String,Object> delete(String id){
        Map<String,Object> map = new HashMap<>();
        int i = userService.deleteUser(id);
        if(i>0){
            map.put("state","success");

        }else{
            map.put("state","error");
        }
        return map;
    }

    @RequestMapping(value = "/test/code.html",method = RequestMethod.GET)
    public void getCode(HttpSession session, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        //生成随机字符串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        session.setAttribute("code_rand",verifyCode.toLowerCase());
        try {
            VerifyCodeUtils.outputImage(PIC_H,PIC_W,response.getOutputStream(),verifyCode);
        }catch (IOException e){
            logger.error("生成验证码异常！");
        }
    }
    /*@Scheduled(cron = "0/5 * * * * ? ")*/
   /* public void testQuartz() {*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String time = sdf.format(d);
        System.err.println("定时任务,5秒执行一次"+time);*/
        /*Object obj = null;
        if(obj == null){
            System.out.println("success");
        }else{
            System.out.println("error");
        }*/
    /*}*/
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.optString("");
        String json = "JSON";
        Object obj = null;
        if(json.equals("JSON")){
            System.out.println("success");
        }else{
            System.out.println("error");
        }
        TestBean testBean = TestBean.getInstance();
        testBean.setName("Tom");
        TestBean testBean1 = TestBean.getInstance();
        testBean1.setName("Ming");
        
        testBean.printInfo();
        testBean1.printInfo();
        if(testBean == testBean1){
            System.out.println("创建的是同一个实例");
        }else{
            System.out.println("创建的不是同一个实例");
        }
        String i = "3";
        switch (i){
            case "1":
                System.out.println("this is 1");
                break;
            case "2":
                System.out.println("this is 2");
                break;
            case "3":
                System.out.println("this is 3");
                break;
            default:
                System.out.println("this is default");

        }
        /*boolean flag=false;
        for(int i=0;i<10 && !flag ;i++)	{
            for(int j=0;j<10;j++)		{
                System.out.println("i=" + i + ",j=" + j);
                if(j == 5){
                    flag = true;
                    break;
                }
            }
        }*/


    }
}
