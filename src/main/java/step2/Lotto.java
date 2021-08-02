package step2;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create(List<Integer> expectedArrays) {
        return new Lotto(expectedArrays);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
