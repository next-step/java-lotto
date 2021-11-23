package step1;

import java.util.LinkedList;
import java.util.List;

public class Numbers {

    private static final int DEFAULT_SIZE = 0;
    private static final int FIRST_NUMBER = 0;
    private static final int INITIAL_NUMBER  = 0;

    private final List<Number> numbers;

    public Numbers() {
        this(new String[DEFAULT_SIZE]);
    }

    public Numbers(String[] stringNumbers) {
        numbers = new LinkedList<>();
        for (String num : stringNumbers) {
            numbers.add(new Number(num));
        }
    }

    public Number sum() {
        Number ans = new Number(INITIAL_NUMBER);

        while (hasNextNumber()) {
            ans = ans.add(nextNumber());
        }
        return ans;
    }

    private boolean hasNextNumber() {
        return !numbers.isEmpty();
    }

    private Number nextNumber() {
        return numbers.remove(FIRST_NUMBER);
    }
}
