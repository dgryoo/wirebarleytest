package exchangeService.controller;

import exchangeService.model.ResponseBodyObject;
import exchangeService.model.ExchangeRateName;
import exchangeService.model.ExchangeRateObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.text.ParseException;

@RestController
public class ExchangeRateController {

    String url = "http://api.currencylayer.com/live?";
    String key = "access_key=c93259b4e7a38a3ebd04698d3b956162";
    String searchCountryCondition = "&currencies=";
    RestTemplate restTemplate = new RestTemplate();
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");


    @GetMapping("/exchangeRateObject")
    public ResponseEntity<ExchangeRateObject> getExchangeRateByRecipientCountry(@RequestParam String recipientCountry) {

        // enum
        ExchangeRateName exchangeRateName = ExchangeRateName.valueOf(recipientCountry);

        // 환율정보
        double exchangeRate = getExchangeRate(exchangeRateName.name());


        // model
        ExchangeRateObject exchangeRateObject = new ExchangeRateObject(exchangeRateName.getRecipientCountry(),
                decimalFormat.format(exchangeRate),
                exchangeRateName.getUsdExchangeRateName());


        // return
        return ResponseEntity.status(HttpStatus.OK).body(exchangeRateObject);

    }

    @GetMapping("/exchangeRateValue")
    public ResponseEntity<String> getExchangeRateByRecipientCountry(@RequestParam String exchangeRateString,
                                                                          @RequestParam Integer usdCount) throws ParseException {
        // DecimalFormat String to Double
        Double exchangeRate = decimalFormat.parse( exchangeRateString ).doubleValue();

        // calculate ExchangeValue and apply decimalFormat
        String calculateExchangeValue = decimalFormat.format(exchangeRate * usdCount);

        // return
        return ResponseEntity.status(HttpStatus.OK).body(calculateExchangeValue);

    }

    public double getExchangeRate(String recipientCountry) {

        // 환율정보 quotes를 포함한 Class
        ResponseBodyObject result = restTemplate.getForObject(
                url + key + searchCountryCondition + recipientCountry,
                ResponseBodyObject.class
        );

        // return
        return result.getQuotes().get("USD" + recipientCountry);

    }

}
