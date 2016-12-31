package org.springframework.samples.mvc.accounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/accounts/*")
public class AccountsController {
    @RequestMapping("active")
    public @ResponseBody String active() {
        return "ACTIVE accounts";
    }

    @RequestMapping("inactive")
    public @ResponseBody String inactive() {
        return "IN_ACTIVE accounts";
    }
}