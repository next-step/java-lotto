package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final List<Integer> NUMBERS;

    static {
        NUMBERS = new ArrayList<>();
        for (int i = LottoNumber.LOTTO_NUMBER_START; i <= LottoNumber.LOTTO_NUMBER_END; i++) {
            NUMBERS.add(i);
        }
    }

    public static List<LottoNumber> shuffleAndGet() {
        Collections.shuffle(NUMBERS);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LottoNumber.of(NUMBERS.get(i)));
        }
        return lottoNumbers;
    }
}
