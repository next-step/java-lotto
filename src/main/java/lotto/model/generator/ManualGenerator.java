package lotto.model.generator;

import lotto.exception.NumbersIsEmptyException;
import lotto.model.Lotto;
import lotto.model.Number;
import lotto.utils.StringUtils;

import java.util.List;


public class ManualGenerator implements LottoGenerator {

    private final List<Number> numbers;

    public ManualGenerator(String numberOfLotto) {
        if (numberOfLotto == null || numberOfLotto.isEmpty()) {
            throw new NumbersIsEmptyException();
        }
        this.numbers = StringUtils.parseNumbers(numberOfLotto);
    }

    @Override
    public Lotto generator() {
        return Lotto.from(numbers);
    }
}