package lotto.service;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomNumberGenerator {

    public static final int MAX_BOUND_NUM = 100;

    private static final List<Integer> source = IntStream.range(0, MAX_BOUND_NUM).boxed().collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(source);
        return source;
    }

}
