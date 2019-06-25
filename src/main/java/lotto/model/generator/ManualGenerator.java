package lotto.model.generator;

import lotto.exception.NumbersIsEmptyException;
import lotto.model.Lotto;
import lotto.model.Number;

import java.util.Arrays;
import java.util.List;


import static java.util.stream.Collectors.toList;

public class ManualGenerator implements LottoGenerator {

    public static final String LOTTO_NUMBERS_SEPARATOR = ",";
    private final List<Number> numbers;

    public ManualGenerator(String numberOfLotto) {
        if (numberOfLotto == null || numberOfLotto.isEmpty()) {
            throw new NumbersIsEmptyException();
        }
        List<Number> numbers = Arrays.stream(numberOfLotto.split(LOTTO_NUMBERS_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(toList());
        this.numbers = numbers;
    }

    @Override
    public Lotto generator() {
        return Lotto.from(numbers);
    }
}