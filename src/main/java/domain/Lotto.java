package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> numbers;

    protected Lotto(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public static Lotto of(int... numbers) {
        Lotto lotto = new Lotto(Arrays.stream(numbers)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet()));

        if (lotto.getNumbers().size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개의 숫자를 가질 수 있습니다");
        }

        return lotto;
    }

    public static Lotto generate() {
        return Lotto.of(new Random()
                .ints(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER + 1)
                .distinct().limit(LOTTO_NUMBER_COUNT).toArray());
    }
}
