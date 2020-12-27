package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputNumbers {

    private List<InputNumber> numbers = new ArrayList<>();

    public InputNumbers(String[] inputs) {
        if (inputs == null) {
            throw new RuntimeException("input 값이 null이면 안됩니다.");
        }
        this.numbers = Arrays.stream(inputs).map(InputNumber::new)
            .collect(Collectors.toList());
    }

    public int sum() {
        int sum = 0;
        for (InputNumber inputNumber : numbers) {
            sum += inputNumber.getNumber();
        }
        return sum;
    }
}
