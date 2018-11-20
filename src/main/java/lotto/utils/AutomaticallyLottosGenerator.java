package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class AutomaticallyLottosGenerator implements LottosGenerator {

    @Override
    public List<Lotto> generate(final Money money) {
        return createLottos(money);
    }

    private List<Lotto> createLottos(final Money money) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.calculateLottoCountToPurchasedAutomatically(); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
