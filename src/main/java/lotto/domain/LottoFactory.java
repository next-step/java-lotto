package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<LottoNumber> LOTTO_BASKET = new ArrayList<>(LottoNumber.values());
    private static final int MIN_BALL_NUMBER_TO_SELECT = 0;
    private static final int MAX_BALL_NUMBER_TO_SELECT = 6;

    public static Lotto createLottoAutomatically() {
        Collections.shuffle(LOTTO_BASKET);
        List<LottoNumber> lottoNumbers = LOTTO_BASKET.subList(MIN_BALL_NUMBER_TO_SELECT, MAX_BALL_NUMBER_TO_SELECT);
        return new Lotto(lottoNumbers);
    }
}
