package validator;

import utils.MathUtils;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ArithmeticInputValidator {

    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");

    private ArithmeticInputValidator() { //인스턴스화 방지
    }

    public static String[] validateArithmeticInput(String input) {
        validateNullOrBlankInput(input);
        String[] operandsAndOperators = splitInputAndCheckSize(input);
        return validateInputComponents(operandsAndOperators);
    }

    private static String[] splitInputAndCheckSize(String input) {
        String[] operandsAndOperators = StringUtils.splitByPattern(input);
        if (MathUtils.isEvenValue(operandsAndOperators.length)) {
            throw new IllegalArgumentException("사칙연산 입력 패턴을 다시 확인해주세요. length : " + operandsAndOperators.length);
        }
        return operandsAndOperators;
    }

    private static void validateNullOrBlankInput(String input) {
        boolean isInvalidInput = input == null || input.isBlank();

        if (isInvalidInput) {
            throw new IllegalArgumentException("null, empty 값은 입력할 수 없습니다.");
        }
    }

    private static String[] validateInputComponents(String[] operandsAndOperators) {
        for (int i = 0; i < operandsAndOperators.length; i++) {
            validateOperandAndOperators(operandsAndOperators[i], i);
        }
        return operandsAndOperators;
    }

    private static boolean validateOperandAndOperators(String operandsOrOperator, int index) {
        if (MathUtils.isEvenValue(index)) {
            return validateOperand(operandsOrOperator);
        }
        return validateOperator(operandsOrOperator);
    }

    private static boolean validateOperator(String operator) {
        if (!OPERATORS.contains(operator)) {
            throw new IllegalArgumentException("사칙연산 문자는 +, -, *, / 만 입력 가능합니다. input : " + operator);
        }
        return true;
    }

    private static boolean validateOperand(String operand) {
        try {
            parseInt(operand);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사칙연산 기호자리에 숫자가 입력되었습니다. input : " + operand);
        }
    }
}
