package step1;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Numbers {

    private final int[] numbers;

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

    public boolean hasOneNumber() {
        return numbers.length == 1;
    }

    public int pickFirstValueIfHasOneNumber() {
        if (!hasOneNumber()) {
            throw new RuntimeException("하나의 숫자만 가지고 있어야 합니다.");
        }
        return numbers[0];
    }

    public int plusNumbers() {
        return hasOneNumber() ?
                pickFirstValueIfHasOneNumber() :
                Arrays.stream(numbers).reduce(0, Integer::sum);
    }

}
