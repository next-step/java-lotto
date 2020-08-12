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

    public static Numbers create(List<String> strings) {
        return strings.stream()
                .map(StringUtils::toNumber)
                .collect(collectingAndThen(Collectors.toList(), Numbers::new));
    }

    public void hasNegativeNumber() {
    }
}
