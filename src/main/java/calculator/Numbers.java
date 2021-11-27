package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<String> textNumbers) {
        this.numbers = rapping(textNumbers);
    }

    private List<Number> rapping(List<String> stringNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (String textNumber : stringNumbers) {
            numbers.add(new Number(textNumber));
        }
        return numbers;
    }

    public int getResult() {
        int result = 0;
        for (Number number : this.numbers) {
            result += number.getNumber();
        }
        return result;
    }
}
