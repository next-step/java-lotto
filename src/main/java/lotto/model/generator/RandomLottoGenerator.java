package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private NumberGenerator numberGenerator;

    public RandomLottoGenerator() {
        this.numberGenerator = new NumberGenerator();
    }

    @Override
    public Lotto generator() {
        numberGenerator.shuffle();
        List<Number> numbers = numberGenerator.peek(Lotto.SIZE);
        return Lotto.from(numbers);
    }
}