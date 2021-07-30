package edu.nextstep.lotto.step1.domain;

import java.util.List;

public class DefaultSumCalculator implements SumCalculator {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력 가능합니다.";
    private static final String CAN_NEGATIVE_EXCEPTION = "음수는 사용할 수 없습니다.";

    @Override
    public int sum(List<String> tokens) {

        return tokens.stream()
                .mapToInt(token -> {
                    int number;

                    try {
                        number =  Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(NUMBER_FORMAT_EXCEPTION);
                    }

                    if (number < 0) {
                        throw new RuntimeException(CAN_NEGATIVE_EXCEPTION);
                    }

                    return number;
                }).sum();
    }
}
