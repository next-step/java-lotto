package calculator.domain;

public class Calculator {

    public static int calculate(String[] letters) {
        assertArgumentsLengthIsOdd(letters);

        int result = Integer.parseInt(letters[0]);
        for (int operatorIdx = 1, n = letters.length; operatorIdx < n; operatorIdx += 2) {
            result = operate(letters, result, operatorIdx);
        }

        return result;
    }

    private static int operate(String[] letters, int preResult, int operatorIdx) {
        final Operator operator = Operator.findByName(letters[operatorIdx]);
        return operator.operate(Number.valueOf(preResult), Number.valueOf(letters[operatorIdx + 1]));
    }

    private static void assertArgumentsLengthIsOdd(String[] targets) {
        if (targets == null || targets.length % 2 == 0) {
            throw new IllegalArgumentException("입력 문자열을 확인해주세요.");
        }
    }
}
