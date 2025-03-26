package generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;

    public RandomNumberGenerator() {
        numbers = new ArrayList<>();
        for (int index = 1; index <= 45; index++) {
            numbers.add(index);
        }
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(numbers);
        return numbers.subList(0 ,6);
    }
}
