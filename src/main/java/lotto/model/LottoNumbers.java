package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static lotto.common.LottoConstants.*;

public class LottoNumbers {
    private final TreeSet<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> numbers) {
        validateLottoNumbersSize(numbers, LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        this.lottoNumbers = new TreeSet<>(comparingInt(LottoNumber::number));
        this.lottoNumbers.addAll(numbers);
    }

    public LottoNumbers(String number) {
        this(stringNumbersToLottoNumbers(number));
    }

    private static Set<LottoNumber> stringNumbersToLottoNumbers(String lottoNumber) {
        return Arrays.stream(lottoNumber.split(SPLIT_SYMBOL))
                .map(String::trim)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    private void validateLottoNumbersSize(Set<LottoNumber> lottoNumbers, String message) {
        if (!(lottoNumbers.size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(message);
        }
    }

    public TreeSet<LottoNumber> lottoNumbers(){
        return lottoNumbers;
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

