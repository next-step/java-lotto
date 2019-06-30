package lotto.model.generator;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    private long countOfLotto;
    private NumberGenerator numberGenerator;

    public RandomLottoGenerator(long countOfLotto) {
        this.countOfLotto = countOfLotto;
        this.numberGenerator = new NumberGenerator();
    }

    @Override
    public List<Lotto> generator() {
        List lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        numberGenerator.shuffle();
        return Lotto.from(numberGenerator.peek(Lotto.SIZE));
    }
}