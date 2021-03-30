package lotto.domain;

import lotto.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersGenerator {
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_MIN_NUM = 1;

    private List<Number> numbers;

    public NumbersGenerator() {
        this.numbers = initNumbers();
    }

    public List<Number> initNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_NUM; num <= LOTTO_MAX_NUM; num++) {
            numbers.add(new Number(num));
        }
        return numbers;
    }

    public static NumbersGenerator createNumbers(){
        return new NumbersGenerator();
    }

    public List<Number> getNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Constant.LOTTO_TOTAL_NUMBER)
                .sorted(Number::compareTo)
                .collect(Collectors.toList());
    }


}
