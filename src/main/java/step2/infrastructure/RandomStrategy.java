package step2.infrastructure;

import step2.domain.NumberGenerateStrategy;

import java.util.*;
import java.util.stream.IntStream;

public class RandomStrategy implements NumberGenerateStrategy {
    private final List<Integer> numberList = new ArrayList<>();

    public RandomStrategy() {
        IntStream.rangeClosed(1, 45)
                .forEach(numberList::add);
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(numberList);
        List<Integer> lottoNumber = numberList.subList(0, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
