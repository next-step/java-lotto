package com.ssabae.nextstep.stringcalculator.calculator;

import com.ssabae.nextstep.stringcalculator.parser.Splitter;
import com.ssabae.nextstep.stringcalculator.validator.Validator;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-14
 */
public class StringAddCalculator {

    private final Validator<List<Integer>> validator;
    private final Splitter splitter;

    public StringAddCalculator() {
        validator = new TotalSumValidator();
        splitter = new Splitter();
    }

    public int calculate(String text) {
        List<Integer> split = splitter.split(text);
        validator.validate(split);
        return split.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

}
