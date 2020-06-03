package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Lotto
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class Lotto {

    private List<Integer> lottoNumbers = new ArrayList<>();

    private Lotto() {

    }

    public static Lotto of(int lottoDrawLimit, List<Integer> lottoGameNumbers) {

        Lotto lotto = new Lotto();

        // shuffle
        Collections.shuffle(lottoGameNumbers);

        // pick LOTTO_DRAW_LIMIT
        lotto.lottoNumbers = drawLottoNumbers(lottoDrawLimit, lottoGameNumbers);
        lotto.lottoNumbers.sort(Integer::compareTo);

        return lotto;

    }

    private static List<Integer> drawLottoNumbers(int lottoDrawLimitIndex, List<Integer> lottoGameNumbers) {
        return lottoGameNumbers.subList(0, lottoDrawLimitIndex);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
    }

}
