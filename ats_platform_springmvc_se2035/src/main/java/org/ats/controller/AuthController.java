package org.ats.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.ats.dto.UserRequest;
import org.ats.entities.User;
import org.ats.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auths")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "auths/login";
    }

    @PostMapping("/login")
    public ModelAndView processLogin(@RequestParam(name = "email") String emailAddress,
                                     @RequestParam(name = "password") String password,
                                     HttpSession session
    ) {
        System.out.println("Email address : " + emailAddress + "; Password: " + password);

        ModelAndView mv = new ModelAndView();
//        try {
        User user = authService.authenticate(new UserRequest(emailAddress, password));
        session.setAttribute("user", user);
//        } catch (Exception e) {
//            mv.addObject("errorMessage", "Invalid email or password");
//            mv.setViewName("auths/login");
//            return mv;
//        }

        mv.setViewName("general_dashboard");

        return mv;
    }

}
