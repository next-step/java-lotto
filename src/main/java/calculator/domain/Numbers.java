package calculator.domain;

import calculator.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class Numbers {
    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(List<String> strings) {
        return strings.stream()
                .map(StringUtils::toNumber)
                .peek(Numbers::validateNegativeNumber)
                .collect(collectingAndThen(Collectors.toList(), Numbers::new));
    }

    public static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력이 불가능합니다.");
        }
    }

    public int add() {
        return this.numbers.stream()
                .reduce(0, Integer::sum);
    }
}
