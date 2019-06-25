package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.List;

public class RandomLottoGenerator implements LottoGenerator{

    @Override
    public Lotto generator() {
        NumberGenerator.shuffle();
        List<Number> numbers = NumberGenerator.peek(Lotto.SIZE);
        return Lotto.from(numbers);
    }
}