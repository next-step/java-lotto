package step1;

import java.util.LinkedList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers() {
        this(new String[0]);
    }

    public Numbers(String[] stringNumbers) {
        numbers = new LinkedList<>();
        for (String num : stringNumbers) {
            numbers.add(new Number(num));
        }
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }

    public Number nextNumber() {
        return numbers.remove(0);
    }
}
