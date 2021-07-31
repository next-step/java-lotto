package lotto.domain;

import lotto.exception.OutOfSizeException;

import java.util.*;
import java.util.stream.Collectors;

public final class Lotto implements Iterable<LottoNumber> {
    public static final Money PRICE = new Money(1000);
    public static final int NUMBER_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private final List<LottoNumber> values;

    public Lotto(List<LottoNumber> numbers) {
        validateNumberSize(numbers);

        this.values = new ArrayList<>(numbers);
        Collections.sort(this.values);
    }

    public static Lotto of(String strLottoNumbers) {
        String removedSpaceNumbers = strLottoNumbers.replaceAll(" +", "");
        return new Lotto(Arrays.stream(
                removedSpaceNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }

    private void validateNumberSize(List<LottoNumber> values) {
        long distinctSize = values.stream().distinct().count();
        if (distinctSize != NUMBER_SIZE || values.size() != NUMBER_SIZE) {
            throw new OutOfSizeException("로또 번호가 6개가 아닙니다.");
        }
    }

    public int containsCount(Lotto that) {
        return (int) that.values.stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.values.contains(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return values.iterator();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) {
            return true;
        }
        if (compareValue == null || getClass() != compareValue.getClass()) {
            return false;
        }
        Lotto that = (Lotto) compareValue;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
