package StringCalculator.model;

import StringCalculator.Exception.InvalidArithmethicException;

public class StringCalculator {
    private static final String DELIMITER = " ";

    private StringCalculator() {
    }

    public static int calculate(String problem) {
        checkInvalid(problem);
        String[] splitedProblem = split(problem);

        return operation(splitedProblem, getNumber(splitedProblem[0]));
    }

    private static String[] split(String problem) {
        String[] result = problem.split(DELIMITER);
        checkInvalid(result);

        return result;
    }

    private static void checkInvalid(String[] problem) {
        if (problem.length < 3) {
            throw new InvalidArithmethicException("3개 미만은 계산할 수 없습니다.");
        }

        if ((problem.length % 2) == 0) {
            throw new InvalidArithmethicException("짝수개는 계산할 수 없습니다.");
        }
    }

    private static void checkInvalid(String problem) {
        if (problem == null) {
            throw new IllegalArgumentException();
        }

        if (problem.equals(DELIMITER)) {
            throw new IllegalArgumentException();
        }

        if (problem.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static int operation(String[] problem, int result) {
        for (int i = 1; i < problem.length; i += 2) {
            result = arithmetic(result, problem[i], getNumber(problem[i + 1]));
        }
        return result;
    }

    private static int getNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("처음과 기호 다음엔 숫자를 입력하여야 합니다.");
        }
    }

    private static int arithmetic(int a, String b, int c) {
        return ArithmeticSign.findSign(b).calculate(a, c);
    }
}
