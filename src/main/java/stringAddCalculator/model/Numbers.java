package stringAddCalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Numbers(String[] splitParam) {
        numbers = new ArrayList<>();
        for (String numberString : splitParam) {
            numbers.add(new Number(numberString));
        }
    }

    public int getAddingResult() {
        return numbers.stream().mapToInt(Number::value).sum();
    }
}
