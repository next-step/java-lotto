package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumber {

    public List<Integer> toInt(String[] stringNumbers) {
        List<Integer> collect;
        try {
            collect = Arrays.stream(stringNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 입력값이 존재합니다.");
        }
        return collect;
    }

    public int add(List<Integer> numbers) {
        valid(numbers);
        return numbers.stream().reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("덧셈중에 오류가 발생했습니다."));
    }

    private void valid(List<Integer> numbers) {
        boolean isNegative = numbers.stream().anyMatch(number -> number < 0);
        if (isNegative) {
            throw new RuntimeException("양수만 덧셈이 가능합니다.");
        }
    }
}