package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator implements Numbers {
    public static final int LOTTO_MAX_NUM = 45;
    public static final int LOTTO_MIN_NUM = 1;
    List<Number> numbers;

    public NumbersGenerator() {
        this.numbers = numbers();
    }

    @Override
    public List<Number> numbers() {
        List<Number> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_NUM; num <= LOTTO_MAX_NUM; num++) {
            numbers.add(new Number(num));
        }
        return numbers;
    }

    @Override
    public List<Number> getNumbers() {
        return numbers;
    }


}
