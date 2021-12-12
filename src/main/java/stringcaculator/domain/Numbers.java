package stringcaculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final String[] numberArr;

    public Numbers(String[] numbers) {
        this.numberArr = numbers;
    }

    public List<Number> numbers() {
        List<Number> numbers = new ArrayList<>(numberArr.length);
        for (String number: numberArr) {
            numbers.add(new Number(new ValidationValueFactory().create(number)));
        }
        return numbers;
    }
}