package stringsumcalculator.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static int calculate(String inputString) {

        int result = 0;

        if (inputString.isEmpty()) {
            return 0;
        }

        Separators separators = new Separators(inputString);
        String formula = separators.getFormula();
        Operands operands = new Operands(formula, separators);

        for (int i = 0; i < operands.getCount(); i++) {
            result += operands.getOperand(i);
        }

        return result;
    }
}
