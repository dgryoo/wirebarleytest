package ExchangeRateApplication.model;

public class ExchangeRateObject {
    private String recipientRateName;
    private String exchangeRate;
    private String exchangeRateName;

    public ExchangeRateObject(String recipientRateName, String exchangeRate, String exchangeRateName) {
        this.recipientRateName = recipientRateName;
        this.exchangeRate = exchangeRate;
        this.exchangeRateName = exchangeRateName;
    }

    public String getRecipientRateName() {
        return recipientRateName;
    }

    public void setRecipientRateName(String recipientRateName) {
        this.recipientRateName = recipientRateName;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getExchangeRateName() {
        return exchangeRateName;
    }

    public void setExchangeRateName(String exchangeRateName) {
        this.exchangeRateName = exchangeRateName;
    }
}
