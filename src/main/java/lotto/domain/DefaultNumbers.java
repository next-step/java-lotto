package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultNumbers {

    private final List<Integer> numbers;
    
    public DefaultNumbers() {
        this.numbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> of() {
        return numbers;
    }
}
