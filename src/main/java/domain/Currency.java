package domain;

import java.util.function.LongBinaryOperator;

public enum Currency {
    KRW("kor", "원", (profitAmount, investmentAmount) -> (profitAmount / investmentAmount));
    private final String countryType;
    private final String currencyType;
    private final LongBinaryOperator returnRateOperation;

    Currency(String countryType, String currencyType, LongBinaryOperator returnRateOperation) {
        this.countryType = countryType;
        this.currencyType = currencyType;
        this.returnRateOperation = returnRateOperation;
    }

    public float calculate(long profitAmount, long investmentAmount) {
        return returnRateOperation.applyAsLong(profitAmount, investmentAmount);
    }

    public String getCurrencyType() {
        return currencyType;
    }
}
