package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<Integer> LOTTO_BASKET;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    static {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER, len = MAX_LOTTO_NUMBER; i <= len; i++) {
            lottoNumbers.add(i);
        }
        LOTTO_BASKET = lottoNumbers;
    }

    public static Lotto createLottoAutomatically() {
        Collections.shuffle(LOTTO_BASKET);
        List<Integer> lotto = LOTTO_BASKET.subList(0, 6);
        Collections.sort(lotto);
        return new Lotto(lotto);
    }
}
