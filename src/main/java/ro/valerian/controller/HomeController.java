package ro.valerian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ro.valerian.entity.UserDtls;
import ro.valerian.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute UserDtls user, Model m, HttpSession session){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");

        UserDtls u=userRepo.save(user);
        if(u!= null){
            session.setAttribute("msg","Register Successfully");
        }else {
            session.setAttribute("msg","Something wrong on server");
        }

        return "redirect:/signup";
    }
}
