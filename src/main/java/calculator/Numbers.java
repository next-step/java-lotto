package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    List<Number> numbers = new ArrayList<>();

    public Numbers(String[] numbers) {
        for (String number : numbers) {
            addToNumbers(new Number(number));
        }
    }

    private void addToNumbers(Number number) {
        numbers.add(number);
    }

    public List<String> toStringList() {
        List<String> list = new ArrayList<>();
        for (Number number : numbers) {
            list.add(number.toString());
        }
        return list;
    }
}