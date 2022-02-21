package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class NumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    private static final List<LottoNumber> numbers;

    static {
        numbers = new ArrayList<>();

        IntStream.rangeClosed(START_NUMBER, LAST_NUMBER).mapToObj(LottoNumber::new)
            .forEach(numbers::add);
    }

    public static Lotto makeAutoLotto() {
        Collections.shuffle(numbers);

        return new Lotto(numbers
            .stream()
            .limit(LOTTO_COUNT)
            .collect(Collectors.toList()));
    }
}
