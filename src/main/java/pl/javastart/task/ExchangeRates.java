package pl.javastart.task;

import java.math.BigDecimal;

public class ExchangeRates {
    private String code;
    private BigDecimal euroRatesToAnotherCurrency;

    public ExchangeRates(String code, BigDecimal euroRatesToAnotherCurrency) {
        this.code = code;
        this.euroRatesToAnotherCurrency = euroRatesToAnotherCurrency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getEuroRatesToAnotherCurrency() {
        return euroRatesToAnotherCurrency;
    }

    public void setEuroRatesToAnotherCurrency(BigDecimal euroRatesToAnotherCurrency) {
        this.euroRatesToAnotherCurrency = euroRatesToAnotherCurrency;
    }

    @Override
    public String toString() {
        return code + " " + euroRatesToAnotherCurrency;
    }
}
