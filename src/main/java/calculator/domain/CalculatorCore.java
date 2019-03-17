package calculator.domain;

import java.util.List;

public class CalculatorCore {

    public static int sum(List<String> splitValues) {
        if (splitValues.isEmpty() || splitValues.contains("")) {
            return 0;
        }

        return splitValues.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
