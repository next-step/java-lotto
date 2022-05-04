package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomPick implements LottoPickStrategy {
    private static final int pickCount = 6;

    @Override
    public List<Integer> numberPick() {
        List<Integer> pick = new ArrayList<>();

        int[] numbers = IntStream.range(1, 46).toArray();
        Integer[] integers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Collections.shuffle(Arrays.asList(integers));
        for (int i = 0; i < pickCount; i++) {
            pick.add(integers[i]);
        }
        return pick;
    }
}
