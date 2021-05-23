package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy {

    public RandomNumberGeneratorStrategy() {
    }

    @Override
    public List<String> generator() {
        return randomSixNumbers();
    }

    private List<String> randomSixNumbers() {
        List<String> availableNumbers = availableAllNumbers();
        Collections.shuffle(availableNumbers);

        return availableNumbers.subList(0, 6);
    }

    private List<String> availableAllNumbers() {
        return IntStream.range(1, 45)
                .mapToObj(number -> String.valueOf(number))
                .collect(Collectors.toList());
    }
}
