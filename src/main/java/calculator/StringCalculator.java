package calculator;

import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
    public int calculate(String formula) {
        StringValidator.checkEmptyString(formula);

        String[] arrFormula = splitFormula(formula);

        StringValidator.checkNumber(arrFormula[0]);
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
        StringValidator.checkOperator(operator);

        StringValidator.checkNumber(Integer.toString(preNumber));

        StringValidator.checkNumber(Integer.toString(postNumber));

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
