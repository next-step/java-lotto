package lotto_auto.model;

import lotto_auto.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumber {

    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private static final Integer LOTTO_NUMBER_MIN_RANGE = 0;
    private static final Integer LOTTO_NUMBER_MAX_RANGE = 45;
    private List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        ThrowIfNull(lottoNumber);
        ThrowIfInValidLottoNumberCount(lottoNumber);
        ThrowIfInvalidLottoNumberRange(lottoNumber);
        ThrowIfDuplicate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> export() {
        return this.lottoNumber;
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

    private void ThrowIfInvalidLottoNumberRange(List<Integer> numbers) {
        List<Integer> filteredList = numbers.stream()
                .filter(item -> item <= LOTTO_NUMBER_MIN_RANGE || item >= LOTTO_NUMBER_MAX_RANGE)
                .collect(Collectors.toList());
        if (filteredList.size() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
        }
    }

    private void ThrowIfDuplicate(List<Integer> numbers) {
        HashSet<Integer> list = new HashSet<>(numbers);
        if (list.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    public int computeMatchCount(LottoNumber lottoNumber) {
        List<Integer> all = new ArrayList<>();
        all.addAll(this.export());
        all.addAll(lottoNumber.export());
        Set<Integer> removeDup = new HashSet<>(all);
        return all.size() - removeDup.size();
    }
}
