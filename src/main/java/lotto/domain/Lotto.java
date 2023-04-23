package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final List<Number> LOTTO_NUMBERS = IntStream.range(Number.MIN_NUMBER, Number.MAX_NUMBER)
                                                               .mapToObj(Number::new).collect(Collectors.toList());
    public static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Number> numbers = LOTTO_NUMBERS.subList(0, LOTTO_SIZE);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Lotto(int... numbers) {
        if (numbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException("숫자는 6개만 입력 가능합니다.");
        }
        this.numbers = Arrays.stream(numbers).mapToObj(Number::new).sorted().collect(Collectors.toList());
    }

    public List<Number> numbers() {
        return numbers;
    }
}
