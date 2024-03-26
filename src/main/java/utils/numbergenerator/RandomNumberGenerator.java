package utils.numbergenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator implements NumberGenerator {
    private static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        List<Integer> copyNumbers = copy(numbers);
        Collections.shuffle(copyNumbers);
        return copyNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Integer> copy(List<Integer> source) {
        return new ArrayList<>(source);
    }
}
