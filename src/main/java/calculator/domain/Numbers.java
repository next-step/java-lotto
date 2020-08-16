package calculator.domain;

import utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class Numbers {
    private List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers of(String input) {
        if (input == null) {
            return new Numbers(Collections.emptyList());
        }

        List<String> strings = split(input);
        return strings.stream()
                .map(StringUtils::toNumber)
                .peek(Numbers::validateNegativeNumber)
                .collect(collectingAndThen(Collectors.toList(), Numbers::new));
    }

    private static List<String> split(String input) {
        String delimiters = DelimiterUtils.findDelimiters(input);
        String filteredInput = DelimiterUtils.filterCustomDelimiter(input);

        return StringSplitter.split(filteredInput, delimiters);
    }

    private static void validateNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력이 불가능합니다.");
        }
    }

    public int add() {
        return this.numbers.stream()
                .reduce(0, Integer::sum);
    }
}
