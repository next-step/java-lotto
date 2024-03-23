package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import utils.numbergenerator.NumberGenerator;

public class LottoFactory {

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLottos(int money, int price) {
        int count = money / price;
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(createLotto(this.numberGenerator.generate()));
            count--;
        }
        return lottos;
    }

    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
