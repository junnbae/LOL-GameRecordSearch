package hello.kms.controller;

import hello.kms.domain.User;
import hello.kms.dto.LoginUserForm;
import hello.kms.dto.RegisterUserForm;
import hello.kms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/checkId")
    @ResponseBody
    public HashMap<String, Boolean> checkId(@RequestParam String id){
        return userService.validateDuplicateId(id);
    }

    @PostMapping("/signUp")
    @ResponseBody
    public HashMap<String, Boolean> signUp(@RequestBody RegisterUserForm form){
        return userService.register(form);
    }

    @PostMapping("/signIn")
    @ResponseBody
    public String signIn(@RequestBody LoginUserForm form, HttpServletResponse response){
        return userService.login(form);
    }

    @GetMapping("/admin/adminUser")
    @ResponseBody
    public List<User> adminUser(){
        return userService.adminUser();
    }
}