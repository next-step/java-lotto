package domain;

import java.util.List;

public class Calculator {
    public static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
