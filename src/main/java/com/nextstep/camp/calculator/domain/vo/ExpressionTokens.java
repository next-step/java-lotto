package com.nextstep.camp.calculator.domain.vo;

import com.nextstep.camp.common.utils.NumberUtils;
import com.nextstep.camp.calculator.domain.exception.NotOddNumberOfValuesException;
import com.nextstep.camp.calculator.domain.exception.NotStartWithNumberException;
import com.nextstep.camp.calculator.domain.exception.TooShortExpressionException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionTokens {

    private final LinkedList<ExpressionToken> values;

    private static final String DEFAULT_DELIMITER = " ";
    private static final int MINIMUM_SIZE = 3;
    private static final int FIRST_TOKEN_INDEX = 0;
    private static final int TOKEN_PAIR_SIZE = 2;

    public ExpressionTokens(String input, String delimiter) {
        String[] split = input.trim().split(delimiter);
        validate(split);
        this.values = new LinkedList<>(toTokens(split));
    }

    public ExpressionTokens(String input) {
        this(input, DEFAULT_DELIMITER);
    }

    private static void validate(String[] split) {
        if (split.length < MINIMUM_SIZE) {
            throw new TooShortExpressionException();
        }
        if (isNotOdd(split)) {
            throw new NotOddNumberOfValuesException();
        }
        if (NumberUtils.isNotNumber(split[FIRST_TOKEN_INDEX])) {
            throw new NotStartWithNumberException();
        }
    }

    private static boolean isNotOdd(String[] split) {
        return split.length % TOKEN_PAIR_SIZE == 0;
    }

    public static ExpressionTokens of(String value) {
        return new ExpressionTokens(value);
    }

    private List<ExpressionToken> toTokens(String[] parts) {
        return Arrays.stream(parts)
                .map(ExpressionToken::of)
                .collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public ExpressionToken poll() {
        return values.poll();
    }
}
