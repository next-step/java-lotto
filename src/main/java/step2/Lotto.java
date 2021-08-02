package step2;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(Integer[] numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    public static Lotto create(Integer[] expectedArrays) {
        return new Lotto(expectedArrays);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
