package calculator.input;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Numbers generateNumbers(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            getnerateNumbers(i, strs[i], numbers);
        }
        return this;
    }

    private static void getnerateNumbers(int i, String str, List<Number> numbers) {
        if (isNumberPosition(i)) {
            numbers.add(new Number(str));
        }
    }

    private static boolean isNumberPosition(int i) {
        return (i + 1) % 2 != 0;
    }
}
