package exchangeService.api;

import exchangeService.model.ExchangeRateName;
import exchangeService.model.ExchangeRateObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExchangeRateApiTest {

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("succeed to get /ExchangeRateObject")
    public void succeedToGetExchangeRateObject() {
        // given
        ExchangeRateName exchangeRateName = ExchangeRateName.KRW;
        String url = "http://localhost:" + port + "/exchangeRateObject";
        String recipientCountryCondition = "?recipientCountry=" + exchangeRateName;

        // when
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<ExchangeRateObject> responseEntity = testRestTemplate
                .getForEntity(url + recipientCountryCondition,
                        ExchangeRateObject.class);

        // then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody().getRecipientRateName(), exchangeRateName.getRecipientCountry());
        assertEquals(responseEntity.getBody().getExchangeRateName(), exchangeRateName.getUsdExchangeRateName());

    }

    @Test
    @DisplayName("succeed to get /calculateExchangeValue")
    public void succeedToGetCalculateExchangeValue() {

        // given
        DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
        String exchangeRate = decimalFormat.format(1194.58);
        int usdCount = 100;
        String url = "http://localhost:" + port + "/calculateExchangeValue";
        String exchangeRateCondition = "?exchangeRateString=" + exchangeRate;
        String usdCountCondition = "&usdCount=" + usdCount;

        String expectedResult = decimalFormat.format(1194.58 * usdCount);


        // when
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> responseEntity = testRestTemplate
                .getForEntity(url + exchangeRateCondition + usdCountCondition,
                        String.class);

        // then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseEntity.getBody(), expectedResult);

    }

}
