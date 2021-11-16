package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private final Integer size;
    private final List<Integer> randomNumbers;
    private static List<Integer> NumberList = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public RandomNumbers(Integer size) {
        this.size = size;
        Collections.shuffle(NumberList);
        this.randomNumbers = NumberList.subList(0,size);
    }
}
