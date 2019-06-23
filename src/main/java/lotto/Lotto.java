package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        numbers = removeDuplicateNumbers(numbers);
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("%d개의 로또번호를 입력해주세요.", LOTTO_SIZE));
        }
        return new Lotto(numbers);
    }

    private static List<Number> removeDuplicateNumbers(List<Number> numbers) {
        numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return numbers;
    }
}
