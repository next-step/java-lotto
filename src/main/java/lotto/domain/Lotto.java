package lotto.domain;

import lotto.exception.OutOfSizeException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lotto implements Iterable<LottoNumber> {
    private final Set<LottoNumber> values;

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_TEMPLATE =
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
        if (values.size() != LOTTO_NUMBER_SIZE) {
            throw new OutOfSizeException("로또 번호가 6개가 아닙니다.");
        }
    }

    private static synchronized Set<LottoNumber> randomNumbers() {
        Set<LottoNumber> newNumbers = new HashSet<>();
        Collections.shuffle(LOTTO_NUMBER_TEMPLATE);
        for (Iterator<LottoNumber> iterator = LOTTO_NUMBER_TEMPLATE.iterator(); newNumbers.size() < 6;) {
            newNumbers.add(iterator.next());
        }
        return newNumbers;
    }

    /* 지금부터 Forward 메서드 */
    @Override
    public Iterator<LottoNumber> iterator() {
        return values.iterator();
    }
}
