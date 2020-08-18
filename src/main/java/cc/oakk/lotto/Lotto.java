package cc.oakk.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(int first, int second, int third, int fourth, int fifth, int sixth) {
        List<Integer> numbers = Stream.of(first, second, third, fourth, fifth, sixth)
                .map(Lotto::throwIfBelowZero)
                .collect(Collectors.toList());
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private static int throwIfBelowZero(int target) {
        if (target <= 0) {
            throw new IllegalArgumentException(String.format("%d is below zero.", target));
        }
        return target;
    }
}
