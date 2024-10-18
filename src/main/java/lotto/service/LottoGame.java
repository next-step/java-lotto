package lotto.service;

import lotto.domain.AutoLotto;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
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

    public Lottos buyAuto(int priceTotal) {
        int lottoCount = priceTotal / LOTTO_PRICE;
        validateBuy(priceTotal, lottoCount);
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(AutoLotto.getInstance()
                    .getLotto());
        }
        return new Lottos(result);
    }

    public void validateBuy(int priceTotal, int count) {
        if (priceTotal < count * LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    public int buyManual(int priceTotal, int buyCount) {
        return priceTotal - (buyCount * LOTTO_PRICE);
    }
}
