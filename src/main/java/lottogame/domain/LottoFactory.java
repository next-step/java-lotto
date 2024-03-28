package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import utils.numbergenerator.NumberGenerator;

public class LottoFactory {

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lottos> createLottoses(Money purchaseAmount, Money price) {
        Number count = Number.from(purchaseAmount.divide(price).convertToInt());
        List<Lottos> lottoses = new ArrayList<>();
        while (count.isPositive()) {
            lottoses.add(createLotto(this.numberGenerator.generate()));
            count = count.decrease();
        }
        return lottoses;
    }

    public Lottos createLotto(List<Integer> numbers) {
        return new Lottos(numbers);
    }
}
