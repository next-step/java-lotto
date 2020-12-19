package lotto.domain;

import java.util.*;

import static lotto.domain.Lotto.LOTTO_NUMBER_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_END;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_START;

public class LottoGenerator {

    private static final List<Integer> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = new ArrayList<>();
        for (int i = LOTTO_NUMBER_START; i <= LOTTO_NUMBER_END; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static Lotto shuffleAndGet() {
        Collections.shuffle(LOTTO_NUMBERS);

        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            lottoNumbers.add(LottoNumber.of(LOTTO_NUMBERS.get(i)));
        }
        return new Lotto(lottoNumbers);
    }
}
