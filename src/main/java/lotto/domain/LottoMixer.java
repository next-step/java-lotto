package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNumber.LOTTO_END_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_START_NUMBER;

class LottoMixer {
    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number < LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(LottoNumber.of(number));
        }
    }

    static List<LottoNumber> mixLottoNumbers() {
        Collections.shuffle(LottoMixer.lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(0, LottoNumbers.LOTTO_NUMBERS_SIZE));
    }
}
