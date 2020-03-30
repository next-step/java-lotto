package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LottoNumberPool {
    static final int LOTTO_START_NUMBER = 1;
    static final int LOTTO_END_NUMBER = 45;
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int number = LOTTO_START_NUMBER; number < LOTTO_END_NUMBER; number++) {
            lottoNumbers.add(LottoNumber.of(number));
        }
    }

    static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(LottoNumberPool.lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(0, LottoTicket.LOTTO_NUMBERS_SIZE));
    }
}
