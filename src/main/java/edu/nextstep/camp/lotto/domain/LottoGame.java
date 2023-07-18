package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_BUY_AMOUNT_UNIT = 1_000;
    private final LottoFactory lottoFactory;

    public LottoGame(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public int numberOfLottoPurchases(int amount) {
        validationMoney(amount);

        return amount / LOTTO_BUY_AMOUNT_UNIT;
    }

    public Lottos buyLotto(int autoCount) {
        return this.buyLotto(autoCount, new ArrayList<>());
    }

    public Lottos buyLotto(int autoCount, List<Lotto> lottos) {
        for (int i = 0; i < autoCount; i++) {
            lottos.add(lottoFactory.createLottoNumbers());
        }

        return new Lottos(lottos);
    }

    private void validationMoney(int amount) {
        if (amount < LOTTO_BUY_AMOUNT_UNIT) {
            throw new IllegalArgumentException("로또 개당 가격은 1,000원 입니다.");
        }
    }


}
