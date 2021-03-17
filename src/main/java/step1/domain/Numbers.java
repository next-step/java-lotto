package step1;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<String> numbers) {
        this.numbers = numbers.stream()
                    .map(this::convertInt)
                    .collect(Collectors.toList());
    }

    private int convertInt(String text) {
        int num = Integer.parseInt(text);

        if (num < 0) {
            throw new NegativeException();
        }

        return num;
    }

    public int sum() {
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        return sum;
    }


}
