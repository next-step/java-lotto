package lotto.domain;

import static lotto.domain.StringConstants.NOT_ENOUGH_MONEY;

public class LottoSeller {

    private static final int LOTTO_PRISE = 1000;

    public static Lottos buy(int money) {
        int buyCount = money / LOTTO_PRISE;
        if (buyCount < 1) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return LottoMachine.generate(buyCount);
    }

    public static MatchResult match(Lottos lottos, Lotto winningLotto) {
        return MatchResult.check(lottos, winningLotto);
    }

}
