package stringcalculator.domain;

import stringcalculator.util.Parser;
import stringcalculator.util.Splitter;

public class StringCalculator {

    private final String formula;

    public StringCalculator(String formula) {
        this.formula = formula;
    }

    public int calculate() {
        String[] inputStrings = Splitter.splitString(this.formula);

        int result = Parser.parseInteger(inputStrings[0]);
        for (int i = 1; i < inputStrings.length; i += 2) {
            OperationType operator = OperationType.getOperator(inputStrings[i]);
            result = operator.calculate(result, Parser.parseInteger(inputStrings[i + 1]));
        }

        return result;
    }
}
