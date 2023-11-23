package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Numbers {
    private static final int COUNT = 6;
    public static final String DELIMITER = ",";
    public static final String REGEX = "^[0-9,\\s]+$";
    private static final List<Number> rangeNumbers = IntStream.rangeClosed(Number.MIN_NUMBER, Number.MAX_NUMBER).boxed().map(Number::new).collect(Collectors.toList());

    private List<Number> numbers;

    // 랜덤 생성
    public Numbers() {
        this.numbers = new ArrayList<>(rangeNumbers);
        Collections.shuffle(this.numbers);
        this.numbers = this.numbers.subList(0, 6);
    }

    // 수동 생성
    public Numbers(String input) {
        this.validateValue(input);

        this.numbers = Stream.of(input.split(DELIMITER))
                .map(number -> new Number(Integer.parseInt(number.trim())))
                .collect(Collectors.toList());

        this.validateCount();
    }

    public List<Boolean> compareNumbers(Numbers targetNumbers) {
        return this.numbers.stream().map(number -> targetNumbers.numbers.stream().anyMatch(target -> target.compareTo(number) == 0)).collect(Collectors.toList());
    }

    public List<Number> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    private void validateValue(String input) {
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    private void validateCount() {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }
}
