package exchangeService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExchangeRatePageController {

    @GetMapping("/exchangeRate")
    public String hello(Model model) {

        return "exchangeRate";

    }


}
