package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Integer> numbers;
    private int currentIndex;

    public Numbers(List<String> numbers) {
        validateEmptyNumbers(numbers);

        this.numbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer nextNumber() {
        validateIndexOutOfSize();

        return numbers.get(currentIndex++);
    }

    public int size() {
        return numbers.size();
    }

    private void validateEmptyNumbers(List<String> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자가 존재하지 않습니다. 숫자를 입력해주세요.");
        }
    }

    private void validateIndexOutOfSize() {
        if (numbers.size() == currentIndex) {
            throw new ReachedMaxIndexException();
        }
    }
}
