package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final double LOTTO_PRICE = 1000;

    private final int numberOfLotto;

    public LottoStore(double money) {
        if (!isValid(money)) {
            throw new IllegalArgumentException();
        }
        this.numberOfLotto = (int)(money / LOTTO_PRICE);
    }

    public List<Lotto> sellLotto() {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(Lotto.getAutoLotto());
        }
        return lottos;
    }

    private boolean isValid(final double money) {
        return (money % LOTTO_PRICE == 0) && (money >= LOTTO_PRICE);
    }

}
