package com.ssabae.nextstep.stringcalculator.validator;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-15
 */
public class PositiveValidator implements Validator<Integer> {

    private static final String ERROR_MESSAGE = "음수는 허용되지 않습니다.";

    @Override
    public boolean validate(Integer s) {
        if (s < 0) {
            throw new RuntimeException(ERROR_MESSAGE);
        }
        return true;
    }
}
