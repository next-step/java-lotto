package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersSelector implements Numbers {
    List<Number> numbers;
    String[] nums;

    public NumbersSelector(String[] numbers) {
        this.nums = numbers;
        this.numbers = numbers();
    }

    @Override
    public List<Number> numbers() {
        List<Number> numbers = new ArrayList<>();
        Arrays.stream(nums).mapToInt(Integer::parseInt).forEach(s -> numbers.add(new Number(s)));
        return numbers;
    }

    @Override
    public List<Number> getNumbers() {
        return numbers;
    }
}
