package lotto.domain;

import exception.CustomException;
import lotto.exception.LottoErrorCode;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int SELECT_SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        checkLottoSize(numbers.size());
        checkOverlap(numbers);
        numbers.sort(Comparator.comparing(LottoNumber::getNumber));
        this.numbers = numbers;
    }

    private void checkOverlap(List<LottoNumber> numbers) {
        List<LottoNumber> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        if (distinct.size() != numbers.size()) {
            throw new CustomException(LottoErrorCode.LOTTO_NUMBER_OVERLAP);
        }
    }

    public static Lotto from(Lotto lotto) {
        return new Lotto(lotto.numbers);
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void checkLottoSize(int size) {
        if (size != SELECT_SIZE) {
            throw new CustomException(LottoErrorCode.LOTTO_SIZE_BAD_REQUEST);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> result = new ArrayList<>();
        for (LottoNumber lotto : numbers) {
            result.add(LottoNumber.from(lotto));
        }
        return result;
    }

    public Long containCount(Lotto lotto) {
        return this.numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return this.numbers
                .contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
