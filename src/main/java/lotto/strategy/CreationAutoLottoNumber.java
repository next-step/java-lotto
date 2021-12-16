package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreationAutoLottoNumber implements CreationLottoNumber {
    private static final int START_SPLIT_NUMBERS = 0;
    private static final int END_SPLIT_NUMBERS = 6;
    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS = LottoNumber.getDefaultLottoNumbers();

    @Override
    public Lotto lottoNumbers(String lottoNumbers) {
        Collections.shuffle(DEFAULT_LOTTO_NUMBERS);
        List<LottoNumber> lottoGroup = new ArrayList<>(DEFAULT_LOTTO_NUMBERS.subList(START_SPLIT_NUMBERS, END_SPLIT_NUMBERS));
        return Lotto.from(lottoGroup);
    }
}
