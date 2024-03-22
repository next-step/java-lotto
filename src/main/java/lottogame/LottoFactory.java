package lottogame;

import java.util.ArrayList;
import java.util.List;
import utils.numbergenerator.NumberGenerator;

public class LottoFactory {

    private static final int PRICE = 1_000;
    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto createLotto() {
        return new Lotto(this.numberGenerator.generate());
    }

    public List<Lotto> createLottos(int money) {
        int count = money / PRICE;
        List<Lotto> lottos = new ArrayList<>();
        while (count > 0) {
            lottos.add(createLotto());
            count--;
        }
        return lottos;
    }
}
