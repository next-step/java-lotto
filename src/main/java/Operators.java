import java.util.Stack;

public class Operators {
    private final Stack<Operator> value;

    public static Operators of(String text) {
        Parameters parameters = new Parameters(text);
        Stack<Operator> operators = new Stack<>();

        for (int i = parameters.length() - 2; i >= 0; i-=2) {
            operators.push(new Operator(parameters.indexOf(i)));
        }

        return new Operators(operators);
    }

    private Operators(Stack<Operator> value) {
        this.value = value;
    }

    public Operator next() {
        return value.pop();
    }

    public boolean hasNext() {
        return !value.isEmpty();
    }
}
