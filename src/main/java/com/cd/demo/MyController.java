package com.cd.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class MyController {

    @RequestMapping("/hi")
    public String index (Model model) {
        model.addAttribute("name", "cd");
        return "hello";
    }

    @RequestMapping(value = "sayHi", method = RequestMethod.GET)
    public void sayHi (HttpServletResponse response) {

        try {
            response.sendRedirect("https://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
