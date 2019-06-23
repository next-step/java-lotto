package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<String> strings) {
        positiveNumbers = strings.stream()
                .map(string -> new PositiveNumber(Integer.parseInt(string)))
                .collect(Collectors.toList());
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return positiveNumbers;
    }
}
