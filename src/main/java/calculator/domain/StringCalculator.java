package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final Expression expression;

    public StringCalculator(String input) {
        this.expression = new Expression(input);
    }

    public int calculate()
    {
        return 0;
    }


}
