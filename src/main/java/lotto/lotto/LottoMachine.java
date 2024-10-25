package lotto.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final static int MIN_PRICE = 1000;

    private final int price;
    private final LottoGeneratorStrategy lottoGeneratorStrategy;

    public LottoMachine(final int price, LottoGeneratorStrategy lottoGeneratorStrategy) {
        validatePrice(price);
        this.price = price;
        this.lottoGeneratorStrategy = lottoGeneratorStrategy;
    }

    public Lottos createLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getExecuteIdx(); i++) {
            Lotto lotto = lottoGeneratorStrategy.generateLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public int getExecuteIdx() {
        return price / 1000;
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("1000원 이상입니다.");
        }
    }
}
