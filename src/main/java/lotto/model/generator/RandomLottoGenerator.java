package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private Money money;
    private NumberGenerator numberGenerator;

    public RandomLottoGenerator(Money money) {
        this.money = money;
        this.numberGenerator = new NumberGenerator();
    }

    @Override
    public List<Lotto> generator() {
        List lottos = new ArrayList<>();
        for (int i = 0; i < money.countAvailableByLotto(); i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        numberGenerator.shuffle();
        return Lotto.from(numberGenerator.peek(Lotto.SIZE));
    }
}