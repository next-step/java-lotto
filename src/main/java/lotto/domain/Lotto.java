package lotto.domain;

import lotto.exception.OutOfSizeException;
import lotto.util.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotto implements Iterable<LottoNumber> {
    private final Set<LottoNumber> values;

    private static final String LOTTO_NUMBER_DELIMITER = ",";
    public static final Money PRICE = new Money(1000);
    private static final int NUMBER_SIZE = 6;
    private static final List<LottoNumber> NUMBER_TEMPLATE =
            IntStream.range(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());

    private Lotto(Set<LottoNumber> numbers) {
        this.values = numbers;

        validValues();
    }

    public static Lotto newManual(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto newAuto() {
        return new Lotto(randomNumbers());
    }

    public static Lotto parse(String strLottoNumbers) {
        return Lotto.newManual(Arrays.stream(
                strLottoNumbers.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet())
        );
    }

    private void validValues() {
        if (values.size() != NUMBER_SIZE) {
            throw new OutOfSizeException("로또 번호가 6개가 아닙니다.");
        }
    }

    private static synchronized Set<LottoNumber> randomNumbers() {
        Set<LottoNumber> newNumbers = new HashSet<>();
        Collections.shuffle(NUMBER_TEMPLATE);
        for (Iterator<LottoNumber> iterator = NUMBER_TEMPLATE.iterator(); newNumbers.size() < 6;) {
            newNumbers.add(iterator.next());
        }
        return newNumbers;
    }

    public LottoRank rank(Lotto prizeLotto) {
        return LottoRank.of(
                containsCount(prizeLotto.values)
        );
    }

    private int containsCount(Set<LottoNumber> lottoNumbers) {
        return (int) values.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    /* 지금부터 Forward 메서드 */
    @Override
    public Iterator<LottoNumber> iterator() {
        return values.iterator();
    }

    @Override
    public boolean equals(Object compareValue) {
        if (this == compareValue) return true;
        if (compareValue == null || getClass() != compareValue.getClass()) return false;
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
