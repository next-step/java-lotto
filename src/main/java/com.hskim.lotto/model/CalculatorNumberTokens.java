package com.hskim.lotto.model;

import com.hskim.lotto.exception.CalculatorException;
import com.hskim.lotto.exception.CalculatorExceptionType;

import java.util.List;
import java.util.Objects;

public class CalculatorNumberTokens {

    private List<String> tokenList;

    public static CalculatorNumberTokens of(UserInput userInput) {
        return userInput.getNumberTokens();
    }

    public CalculatorNumberTokens(List<String> tokenList) {
        for (String token : tokenList) {
            validateNumeric(token);
            validatePositive(token);
        }

        this.tokenList = tokenList;
    }

    private void validateNumeric(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException numberFormatException) {
            throw new CalculatorException(CalculatorExceptionType.CONTAINS_NO_NUMERIC);
        }
    }

    private void validatePositive(String token) {
        if (Integer.parseInt(token) < 0) {
            throw new CalculatorException(CalculatorExceptionType.CONTAINS_NEGATIVE_NUMERIC);
        }
    }

    public int getSum() {
        return tokenList.stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CalculatorNumberTokens)) return false;
        CalculatorNumberTokens that = (CalculatorNumberTokens) o;
        return Objects.equals(tokenList, that.tokenList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenList);
    }
}
