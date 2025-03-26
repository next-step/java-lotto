package step1;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<Operator> operators;

    public Operators(List<String> input) {
        operators = new ArrayList<>();
        for (String operator : input) {
            operators.add(new Operator(operator));
        }
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    public int size() {
        return operators.size();
    }
}
