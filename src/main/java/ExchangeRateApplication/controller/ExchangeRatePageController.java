package ExchangeRateApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExchangeRatePageController {

    @GetMapping("/exchangeRate")
    public String hello(Model model) {

        return "exchangeRate";

    }


}
