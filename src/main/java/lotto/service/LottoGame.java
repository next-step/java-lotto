package lotto.service;

import lotto.domain.AutoLotto;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstants.*;

public class LottoGame {
    private static final List<Integer> lottoNumbers = new ArrayList<>();


    private LottoGame() {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .forEach(lottoNumbers::add);
    }

    private static LottoGame INSTANCE = null;

    public static LottoGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LottoGame();
        }
        return INSTANCE;
    }


    public int getLottoCount(int priceTotal) {
        if (priceTotal < LOTTO_PRICE) {
            throw new IllegalStateException("금액이 부족합니다.");
        }
        return priceTotal / LOTTO_PRICE;
    }

    public List<Lotto> getLottos(int lottoCount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            result.add(AutoLotto.getInstance()
                    .getLotto(lottoNumbers, LOTTO_NUMBER_COUNT));
        }
        return Collections.unmodifiableList(result);
    }

    public Lotto getWinnerLotto(List<Integer> lastWinnerLotto) {
        return new Lotto(lastWinnerLotto);
    }

}
