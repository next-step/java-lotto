package lotto.domain;

import java.util.List;

public class LottoSeller {

    private static final int LOTTO_PRISE = 1000;

    public static List<Lotto> buy(int money) {
        int buyCount = money / LOTTO_PRISE;
        if (buyCount < 1) {
            throw new IllegalArgumentException("돈이 모자랍니다");
        }
        return LottoMachine.generate(buyCount);
    }

    public static List<Lotto> match(List<Lotto> lottos, Lotto winningLotto) {
        // TODO: compare
        return null;
    }

}
