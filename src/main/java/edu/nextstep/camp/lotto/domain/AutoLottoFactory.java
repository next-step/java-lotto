package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static edu.nextstep.camp.lotto.domain.LottoNumber.*;
import static edu.nextstep.camp.lotto.domain.Lotto.LOTTO_NUMBERS_LENGTH;

public class AutoLottoFactory implements LottoFactory {

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public AutoLottoFactory() {
        lottoNumbersInit();
    }

    @Override
    public Lotto createLottoNumbers() {
        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(0, LOTTO_NUMBERS_LENGTH));
    }

    private void lottoNumbersInit() {
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }
}
