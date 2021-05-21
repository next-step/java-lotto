package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final List<Integer> SAMPLE = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    public static final int PRICE = 1000;
    public static final int LOTTO_SIZE = 6;
    public List<Integer> numbers;

    public Lotto() {
        List<Integer> shuffle = new ArrayList<>(SAMPLE);
        Collections.shuffle(shuffle);

        numbers = shuffle.subList(0, LOTTO_SIZE);
    }
}
