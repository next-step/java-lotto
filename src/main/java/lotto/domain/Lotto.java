package lotto.domain;

import lotto.exception.OutOfSizeException;
import lotto.util.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotto implements Iterable<LottoNumber> {
    private final Set<LottoNumber> values;

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

    public static synchronized Lotto newAuto() {
        return new Lotto(randomNumbers());
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

    public LottoRank rank() {
        return LottoRank.FIRST_PLACE;
    }

    /* 지금부터 Forward 메서드 */
    @Override
    public Iterator<LottoNumber> iterator() {
        return values.iterator();
    }
}
