package lotto.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_FIRST_COUNT = 0;
    private static final int LOTTO_LAST_COUNT = 6;

    static {
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> mixLottoNumbers() {
        Collections.shuffle(lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(LOTTO_FIRST_COUNT, LOTTO_LAST_COUNT));
    }

}
