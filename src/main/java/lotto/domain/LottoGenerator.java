package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoGenerator {

    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = LottoNumber.MINIMUM_LOTTO_NUMBER; i <= LottoNumber.MAXIMUM_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(LottoNumber.of(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.subList(0, Lotto.LOTTO_SIZE);
        return Lotto.of(new HashSet<>(lottoNumbers));
    }
}
