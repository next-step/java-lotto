package stringcalculator.domain;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<String> numbers) {
        checkPositiveNumbers(numbers);
        this.numbers = numbers.stream().map(Integer::new).collect(Collectors.toList());
    }

    private void checkPositiveNumbers(List<String> numbers) {
        Pattern m = Pattern.compile("[0-9]+");
        for (String numStr : numbers) {
            if (!m.matcher(numStr).find()) {
                throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요");
            }
        }
    }

    public int sum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

