package textcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TextCalculator {

    private static final Pattern VALID_FORMULA_PATTERN = Pattern.compile("^\\d+( [+\\-*/] \\d+)*$");
    private static final String FORMULA_SEPARATOR = " ";

    private final String formula;

    public TextCalculator(String formula){
        this.formula = formula;

        if(validateFormula()){
            throw new IllegalArgumentException("+ - * / 연산자만 가능하며 숫자와 연산자 사이엔 공백이 존재해야 합니다");
        }
    }

    private boolean validateFormula() {
        return !VALID_FORMULA_PATTERN.matcher(formula).matches();
    }

    public int calculate() {
        String[] parsedFormula = splitFormula();
        return calculateFrom(parsedFormula);
    }

    private String[] splitFormula() {
        return this.formula.split(FORMULA_SEPARATOR);
    }

    private int calculateFrom(String[] parsedFormula) {
        int result = findNumber(parsedFormula[0]);

        for (int i = 1; i < parsedFormula.length; i += 2) {
            Operator operator = findOperator(parsedFormula[i]);
            int nextNumber = findNumber(parsedFormula[i + 1]);

            result = applyOperation(operator, result, nextNumber);
        }
        return result;
    }

    private Operator findOperator(String operatorSymbol) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.isSameSymbol(operatorSymbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다"));
    }

    private static int findNumber(String number) {
        return Integer.parseInt(number);
    }

    private int applyOperation(Operator operator, int result, int nextNumber) {
        return operator.apply(result, nextNumber);
    }

}
