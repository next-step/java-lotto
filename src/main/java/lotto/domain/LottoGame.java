package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.List;

public class LottoGame {
    private final Money money;
    private final Lottoes lottoes;

    private LottoGame(final Money money) {
        this.money = money;
        this.lottoes = Lottoes.init();
    }

    public static LottoGame init(final int amount) {
        return new LottoGame(Money.from(amount));
    }

    public void buyLotto(final NumberGenerator numberGenerator, final List<List<Integer>> manualLottoes) {
        buyManualLotto(manualLottoes);
        buyAutoLotto(numberGenerator);
    }

    private void buyManualLotto(final List<List<Integer>> manualLottoes) {
        for (List<Integer> lottoNumbers : manualLottoes) {
            lottoes.buyManualLotto(lottoNumbers);
        }
    }

    private void buyAutoLotto(final NumberGenerator numberGenerator) {
        while (money.isPossibleBuyLotto(lottoes.getLottoCount())) {
            lottoes.buyAutoLotto(numberGenerator);
        }
    }

    public int getLottoCount() {
        return lottoes.getLottoCount();
    }

    public int getMoney() {
        return money.getMoney();
    }

    public Lottoes getLottoes() {
        return lottoes;
    }
}
