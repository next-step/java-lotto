package lotto.domain;

import lotto.exception.OutOfSizeException;

import java.util.Iterator;
import java.util.Set;

public class Lotto implements Iterable<LottoNumber> {
    private final Set<LottoNumber> values;

    private static final int LOTTO_NUMBER_SIZE = 6;

    private Lotto(Set<LottoNumber> numbers) {
        this.values = numbers;

        validValues();
    }

    private void validValues() {
        if (values.size() != LOTTO_NUMBER_SIZE) {
            throw new OutOfSizeException("로또 번호가 6개가 아닙니다.");
        }
    }

    public static Lotto newManual(Set<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto newAuto() {
        return null;
    }

    /* 지금부터 Forward 메서드 */
    @Override
    public Iterator<LottoNumber> iterator() {
        return values.iterator();
    }
}
