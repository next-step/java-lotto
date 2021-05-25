package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.LottoNumber.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;
import static lotto.model.WinningNumbers.SPLIT_SYMBOL;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        normalSize(numbers);
        this.lottoNumbers = numbers;
    }

    public LottoNumbers(String number) {
        this(lottoNumbers(number));
    }

    private static List<LottoNumber> lottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(LottoNumber::lottoNumber)
                .collect(Collectors.toList());
    }

    private void normalSize(List<LottoNumber> lottoNumbers) {
        if (!(new HashSet<>(lottoNumbers).size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        }
    }

    public String printInfo(){
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

