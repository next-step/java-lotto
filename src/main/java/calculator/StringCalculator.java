package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String formula) {
        StringException.checkEmptyString(formula);

        String[] arrFormula = splitFormula(formula);

        StringException.checkNumber(arrFormula[0]);
        int result = Integer.parseInt(arrFormula[0]);

        for (int i = 1; i < arrFormula.length; i += 2) {
            result = operate(result, arrFormula[i], Integer.parseInt(arrFormula[i + 1]));
        }

        return result;
    }

    private String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    private int operate(int preNumber, String operator, int postNumber) {
        StringException.checkOperator(operator);

        StringException.checkNumber(Integer.toString(preNumber));

        StringException.checkNumber(Integer.toString(postNumber));

        return separationOperator().get(operator).calculate(preNumber, postNumber);
    }

    private Map<String, Operation> separationOperator() {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("+", new Plus());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Multiple());
        operationMap.put("/", new Division());

        return operationMap;
    }
}
