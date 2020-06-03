package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final List<Integer> NUMBERS = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                                                        .boxed()
                                                        .collect(Collectors.toList());

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
