package lotto.domain;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.util.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (!isValid(lottoNumbers)) {
            throw new IllegalLottoNumberCountException(lottoNumbers.size());
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers of(String separateNumber) {
        SeparateNumber number = SeparateNumber.of(separateNumber);
        return new LottoNumbers(number.initLottoNumbers());
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    private boolean isValid(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        return nonDuplicateNumbers.size() == LottoNumber.LOTTO_NUMBER_SIZE;
    }
}
