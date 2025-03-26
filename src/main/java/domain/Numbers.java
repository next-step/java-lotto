package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(int bound) {
        numbers = IntStream.rangeClosed(1, bound).boxed().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
