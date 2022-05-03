package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    public static final int price = 1000;
    private static final int pickCount = 6;
    private final List<Integer> pick = new ArrayList<>();

    public Lotto() {
        numberGenerator();
    }

    private void numberGenerator() {
        int[] numbers = IntStream.range(1, 46).toArray();
        Integer[] integers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Collections.shuffle(Arrays.asList(integers));

        for (int i = 0; i < pickCount; i++) {
            pick.add(integers[i]);
        }
    }

    public List<Integer> pick() {
        Collections.sort(pick);
        return pick;
    }
}
