package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers implements Cloneable{

    private static final int SIZE = 6;

    private static List<Integer> NumberList = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private final List<Integer> randomNumbers;

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public RandomNumbers() {
        Collections.shuffle(NumberList);
        this.randomNumbers = NumberList.subList(0, SIZE).stream().collect(Collectors.toList());
    }
}
