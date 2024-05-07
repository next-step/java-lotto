import java.util.Stack;

public class Digits {
    private final Stack<Integer> value;

    public static Digits of(String text) {
        Parameters parameters = new Parameters(text);
        Stack<Integer> digits = new Stack<>();

        for (int i = parameters.length() - 1; i >= 0; i -= 2) {
            digits.push(Integer.valueOf(parameters.indexOf(i)));
        }

        return new Digits(digits);
    }

    private Digits(Stack<Integer> value) {
        this.value = value;
    }

    public int next() {
        return value.pop();
    }

    public boolean hasNext() {
        return !value.isEmpty();
    }
}
