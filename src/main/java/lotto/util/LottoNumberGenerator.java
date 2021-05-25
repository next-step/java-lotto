package lotto.util;

import lotto.model.LottoNumber;

import java.util.HashSet;
import java.util.Set;

import static lotto.model.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.model.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static Set<LottoNumber> makeLottoNumber() {
        Set<LottoNumber> lotto = new HashSet<>();

        while (lotto.size() < CORRECT_LOTTO_NUMBERS_SIZE) {
            lotto.add(new LottoNumber(makeRandomNumber()));
        }

        return lotto;
    }

    private static Integer makeRandomNumber() {
        return (int) (Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }
}
