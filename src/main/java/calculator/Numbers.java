package calculator;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Numbers {

    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(String[] numbersOfString) {
        List<Integer> numbers = Arrays.stream(numbersOfString)
                .map(Integer::new)
                .collect(toList());
        return new Numbers(numbers);
    }

    public int sum() {
        return numbers.stream().reduce(0, Integer::sum);
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
