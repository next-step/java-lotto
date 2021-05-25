package lotto.util;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.HashSet;
import java.util.Set;

import static lotto.model.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.model.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;

public class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lotto makeLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < CORRECT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(new LottoNumber(makeRandomNumber()));
        }

        return new Lotto(lottoNumbers);
    }

    private static Integer makeRandomNumber() {
        return (int) (Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }
}
