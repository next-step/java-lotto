package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        ThrowIfNull(lottoNumbers);
        ThrowIfInValidLottoNumberCount(lottoNumbers);
        ThrowIfDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers() {

    }

    public List<LottoNumber> export() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private void ThrowIfDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void ThrowIfNull(List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_LOTTO_NUMBER);
        }
    }

    private void ThrowIfInValidLottoNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public int computeMatchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.export()
                .stream()
                .filter(this::contains)
                .count();
    }
}
