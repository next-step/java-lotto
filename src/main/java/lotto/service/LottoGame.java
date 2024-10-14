package lotto.service;

import lotto.domain.AutoLotto;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private LottoGame() {
    }

    private static LottoGame INSTANCE = null;

    public static LottoGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LottoGame();
        }
        return INSTANCE;
    }

    public List<Lotto> buy(int priceTotal) {
        if (priceTotal < LOTTO_PRICE) {
            throw new IllegalStateException("금액이 부족합니다.");
        }
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < priceTotal / LOTTO_PRICE; i++) {
            result.add(AutoLotto.getInstance()
                    .getLotto());
        }
        return Collections.unmodifiableList(result);
    }

}
