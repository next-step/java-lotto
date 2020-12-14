package com.ssabae.nextstep.stringcalculator.calculator;

import com.ssabae.nextstep.stringcalculator.validator.PositiveValidator;
import com.ssabae.nextstep.stringcalculator.validator.Validator;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-15
 */
public class TotalSumValidator implements Validator<List<Integer>> {

    private final PositiveValidator positiveValidator;

    public TotalSumValidator() {
        positiveValidator = new PositiveValidator();
    }

    @Override
    public boolean validate(List<Integer> integers) {
        return integers.stream()
                .allMatch(positiveValidator::validate);
    }
}
