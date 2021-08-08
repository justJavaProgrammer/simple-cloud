package org.odeyalo.simplecloud.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping("/simple-cloud")
    public String getPage() {
        return "Main";
    }
}
