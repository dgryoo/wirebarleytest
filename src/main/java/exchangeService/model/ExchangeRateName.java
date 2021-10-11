package exchangeService.model;

public enum ExchangeRateName {

    KRW("한국(KRW)", "KRW/USD"),
    JPY("일본(JPY)", "JPY/USD"),
    PHP("필리핀(PHP)", "PHP/USD");


    private String recipientCountry;
    private String usdExchangeRateName;

    ExchangeRateName(String recipientCountry, String usdExchangeRateName) {
        this.recipientCountry = recipientCountry;
        this.usdExchangeRateName = usdExchangeRateName;
    }

    public String getRecipientCountry() {
        return recipientCountry;
    }

    public String getUsdExchangeRateName() {
        return usdExchangeRateName;
    }

    public static ExchangeRateName fromRecipientCountry(String recipientCountry) {
        for(ExchangeRateName e : ExchangeRateName.values()) {
            if(e.recipientCountry.equals(recipientCountry)) return e;
        }
        return null;
    }
}
