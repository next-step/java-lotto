package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.List;

public class LottoGame {
    private final Lottoes lottoes;
    private final Money money;

    private LottoGame(final Money money) {
        this.lottoes = Lottoes.init();
        this.money = money;
    }

    public static LottoGame init(final int amount) {
        return new LottoGame(Money.from(amount));
    }

    public void buyLotto(final NumberGenerator numberGenerator) {
        while (money.isPossibleBuyLotto(lottoes.getLottoCount())) {
            lottoes.buyLotto(numberGenerator);
        }
    }

    public int getLottoCount() {
        return lottoes.getLottoCount();
    }

    public Lottoes getLottoes() {
        return lottoes;
    }
}
