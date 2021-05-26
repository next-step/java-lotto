package lotto.model;

import lotto.LottoUtil;

import java.util.*;

import static java.util.Comparator.*;
import static lotto.common.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.common.LottoConstants.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;

public class LottoNumbers {
    private final TreeSet<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> numbers) {
        LottoUtil.validateLottoNumbersSize(numbers, LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        this.lottoNumbers = new TreeSet<>(comparingInt(LottoNumber::number));
        this.lottoNumbers.addAll(numbers);
    }

    public LottoNumbers(String number) {
        this(LottoUtil.stringNumbersToLottoNumbers(number));
    }

    public String printInfo() {
        return ((List<LottoNumber>) new ArrayList<>(lottoNumbers)).toString();
    }

    public int correctCount(TreeSet<LottoNumber> winningNumbers) {
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

