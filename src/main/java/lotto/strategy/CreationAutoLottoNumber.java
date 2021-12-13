package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreationAutoLottoNumber implements CreationLottoNumber {
    private static final int START_SPLIT_NUMBERS = 0;
    private static final int END_SPLIT_NUMBERS = 6;
    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS = LottoNumber.getDefaultLottoNumbers();

    @Override
    public List<LottoNumber> lottoNumbers(String lottoNumbers) {
        Collections.shuffle(DEFAULT_LOTTO_NUMBERS);
        return new ArrayList<>(DEFAULT_LOTTO_NUMBERS.subList(START_SPLIT_NUMBERS, END_SPLIT_NUMBERS));
    }
}
