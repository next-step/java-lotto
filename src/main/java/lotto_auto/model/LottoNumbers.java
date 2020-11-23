package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        ThrowIfNull(lottoNumbers);
        ThrowIfInValidLottoNumberCount(lottoNumbers);
        ThrowIfDuplicate(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> export() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private void ThrowIfNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_LOTTO_NUMBER);
        }
    }

    private void ThrowIfInValidLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    private void ThrowIfDuplicate(List<Integer> numbers) {
        HashSet<Integer> list = new HashSet<>(numbers);
        if (list.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        List<LottoNumber> collect = this.lottoNumbers.stream()
                .filter(item -> item.equals(lottoNumber))
                .collect(Collectors.toList());
        if (collect.size() != 0) {
            return true;
        }
        return false;
    }

    public int computeMatchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.export()
                .stream()
                .filter(item -> contains(item))
                .count();
    }
}
