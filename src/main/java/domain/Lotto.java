package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

    private Random random = new Random();
    private static final int SIZE = 6;
    private static final int LOW_BOUND = 1;
    private static final int HIGH_BOUND = 45;
    private List<Integer> numbers;

    public Lotto() {
        numbers = Arrays.stream(
            random.ints(SIZE, LOW_BOUND, HIGH_BOUND).toArray())
        .boxed().collect(Collectors.toList());

        validateLength();
        Collections.shuffle(numbers);
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateLength() {
        if(this.numbers.size() == 6){
            throw new RuntimeException();
        }
    }

}
