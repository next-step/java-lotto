package calculator.domain;

import java.util.ArrayList;
import java.util.List;

import static calculator.utils.UtilsString.isNullOrEmpty;

public class Numbers {
    List<Number> numbers = new ArrayList<>();

    public Numbers(String[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

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

    public int sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum = number.accumulate(sum);
        }
        return sum;
    }
}