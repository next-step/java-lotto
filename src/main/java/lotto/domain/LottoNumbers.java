package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.util.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    private LottoNumbers(SeparateNumber separateNumber) {
        this.lottoNumbers = toLottoNumbers(separateNumber);
    }

    public static LottoNumbers of(String separateNumber) {
        return new LottoNumbers(SeparateNumber.of(separateNumber));
    }

    private List<Integer> toLottoNumbers(SeparateNumber separateNumber) {
        List<Integer> numbers = separateNumber.initLottoNumbers();
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        int size = nonDuplicateNumbers.size();
        if (size != LottoNumber.LOTTO_NUMBER_SIZE) {
            throw new IllegalLottoNumberCountException(size);
        }
        return numbers;
    }
}
