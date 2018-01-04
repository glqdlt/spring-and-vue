package com.glqdlt.seminardemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

    @Value("${greeting.url}")
    private String greetingUrl;

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("list", sampleService.getList());
        model.addAttribute("apiUrl", greetingUrl);
        return "index";
    }

}
