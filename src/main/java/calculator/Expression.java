package calculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private final List<Integer> numbers;

    public Expression(String... elements) {
        numbers = new ArrayList<>();
        for (String e : elements) {
            numbers.add(Integer.valueOf(e));
        }
    }

    public int addNumbers() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
