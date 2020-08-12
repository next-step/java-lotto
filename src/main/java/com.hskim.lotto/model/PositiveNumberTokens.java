package com.hskim.lotto.model;

import com.hskim.lotto.exception.CalculatorException;
import com.hskim.lotto.exception.CalculatorExceptionType;

import java.util.List;

public class PositiveNumberTokens {

    public List<String> tokenList;

    public PositiveNumberTokens(List<String> tokenList) {

        for(String token : tokenList) {

            validateNumeric(token);
            validatePositive(token);
        }

        this.tokenList = tokenList;
    }

    private void validateNumeric(String token) {

        try {

            double d = Integer.parseInt(token);

        } catch (NumberFormatException nfe) {

            throw new CalculatorException(CalculatorExceptionType.CONTAINS_NO_NUMERIC);
        }
    }

    private void validatePositive(String token) {

        if(Integer.parseInt(token) < 0) {

            throw new CalculatorException(CalculatorExceptionType.CONTAINS_NEGATIVE_NUMERIC);
        }
    }

    public List<String> getTokenList() {

        return tokenList;
    }
}
