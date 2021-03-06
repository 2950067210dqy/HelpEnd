package com.dqy.helpeachothers.controller;

import com.dqy.helpeachothers.entity.User;
import com.dqy.helpeachothers.service.UserService;
import com.dqy.helpeachothers.vo.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    ReturnVO returnVO;

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ReturnVO update(@RequestBody User user){
        returnVO =new ReturnVO();
        User updateUser =user;
        Integer result =userService.update(user);
        if (result==0){
            returnVO.setCode(500);
            returnVO.setMessage("更新信息失败！");
        }else{
            updateUser=userService.selectById(user.getId());
            returnVO.setCode(200);
            returnVO.setMessage("更新信息成功！");
        }
        returnVO.setData(updateUser);
        return returnVO;
    }

    @RequestMapping(value = "/updateHeadImg",method = RequestMethod.POST)
    public ReturnVO updateHeadImg(@RequestBody User user){
        returnVO =new ReturnVO();
        User updateUser =user;
        Integer result =userService.updateHeadImg(user);

        if (result==0){
            returnVO.setCode(500);
            returnVO.setMessage("更新头像失败！");
        }else{
            updateUser=userService.selectById(user.getId());
            returnVO.setCode(200);
            returnVO.setMessage("更新头像成功！");
        }
        returnVO.setData(updateUser);
        return returnVO;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ReturnVO login( String phone , String password){
        returnVO =new ReturnVO();
        User loginUser =userService.login(phone,password);
        if (loginUser!=null){
            returnVO.setCode(200);
            returnVO.setMessage("登录成功");
            returnVO.setData(loginUser);
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("登录失败");
        }
        return  returnVO;
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public ReturnVO selectById( Integer userid){
        returnVO =new ReturnVO();
        User user =userService.selectById(userid);
        if (user !=null){
            returnVO.setCode(200);
            returnVO.setMessage("登录成功");
            returnVO.setData(user );
        }else{
            returnVO.setCode(500);
            returnVO.setMessage("登录失败");
        }
        return  returnVO;
    }

    @RequestMapping(value = "/register")
    public ReturnVO register(@RequestBody User user){
        returnVO =new ReturnVO();
        Integer result =userService.register(user);
        if (result==-1){
            returnVO.setCode(500);
            returnVO.setMessage("注册的角色重复，请重新注册");
        }else if (result==0){
            returnVO.setCode(500);
            returnVO.setMessage("注册失败，请重新注册");
        }else{
            returnVO.setCode(200);
            returnVO.setMessage("注册成功");
        }
        return  returnVO;
    }
}
