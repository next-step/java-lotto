package step1.domain;

import java.util.List;

public class Calculator {
    public int addBulk(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }
}
