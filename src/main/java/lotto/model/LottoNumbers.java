package lotto.model;

import lotto.LottoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.model.LottoNumber.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        LottoUtil.validateLottoNumbersSize(numbers, LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        this.lottoNumbers = numbers;
    }

    public LottoNumbers(String number) {
        this(LottoUtil.stringNumbersToLottoNumbers(number));
    }

    public String printInfo() {
        return ((List<LottoNumber>) new ArrayList<>(lottoNumbers)).toString();
    }

    public int correctCount(List<LottoNumber> winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>(winningNumbers);
        numbers.removeAll(lottoNumbers);
        return LOTTO_NUMBER_COUNT - numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

