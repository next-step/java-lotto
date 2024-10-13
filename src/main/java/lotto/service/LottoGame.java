package lotto.service;

import lotto.domain.AutoLotto;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private static final List<Integer> lottoNumbers = new ArrayList<>();


    private LottoGame() {
        IntStream.rangeClosed(Lotto.LOTTO_START_NUMBER, Lotto.LOTTO_END_NUMBER)
                .forEach(lottoNumbers::add);
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
                    .getLotto(lottoNumbers, Lotto.LOTTO_NUMBER_COUNT));
        }
        return Collections.unmodifiableList(result);
    }

    public Lotto getWinnerLotto(List<Integer> lastWinnerLotto) {
        return new Lotto(lastWinnerLotto);
    }

}
