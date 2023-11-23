package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Numbers {
    private static final int COUNT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final String DELIMITER = ",";

    private final List<Number> numbers;

    // 랜덤 생성
    public Numbers() {
        this.numbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .distinct()
                .limit(COUNT)
                .boxed()
                .map(Number::new)
                .collect(Collectors.toList());

        Collections.shuffle(this.numbers);
    }

    // 수동 생성
    public Numbers(String input) {
        this.validateValue(input);

        this.numbers = Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());

        this.validateCount();
    }

    public List<Boolean> compareNumbers(Numbers targetNumbers) {
        return this.numbers.stream().map(number -> targetNumbers.numbers.stream().anyMatch(target -> target.compareTo(number) == 0)).collect(Collectors.toList());
    }

    public List<Number> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validateValue(String input) {
        if (!input.matches("^[0-9,\\s]+$")) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    private void validateCount() {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }
}
