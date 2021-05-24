package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringNumbers {

    private final List<StringNumber> numbers;

    public StringNumbers(final String[] input) {
        numbers = new ArrayList<>();
        for (String n : input) {
            numbers.add(new StringNumber(n));
        }
    }

    public int sum() {
        int sum = 0;
        for (StringNumber n : numbers) {
            sum += n.getValue();
        }
        return sum;
    }

    public List<StringNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
