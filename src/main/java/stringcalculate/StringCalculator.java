package stringcalculate;

import stringcalculate.InputValue;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final int INDEX = 1;
    private final List<String> expression = new ArrayList<>();
    private int result = 0;

    public StringCalculator(InputValue inputValue) {
        this.expression.addAll(inputValue.getExpression());
    }

    public int Calculate() {
        for (int i = 0; i < expression.size(); i++) {

        }
        return result;
    }

}
