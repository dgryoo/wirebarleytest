package ExchangeRateApplication.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class ResponseBodyObject {

    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String source;
    private HashMap<String, Double> quotes;

    public HashMap<String, Double> getQuotes() {
        return quotes;
    }
}
