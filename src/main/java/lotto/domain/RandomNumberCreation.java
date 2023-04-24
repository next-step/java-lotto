package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberCreation implements NumberCreationStrategy {

    @Override
    public List<Integer> createNumber() {
        List<Integer> number = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());
        Collections.shuffle(number);
        List<Integer> sortedNumber = number.subList(0, LOTTO_SIZE);
        Collections.sort(sortedNumber);
        return sortedNumber;
    }
}
