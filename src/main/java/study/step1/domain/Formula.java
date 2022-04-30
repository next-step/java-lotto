package study.step1.domain;

public class Formula {
    private final String formula;

    public Formula(String formula) {
        this.formula = formula;
    }

    public static Formula of(String nextLine) {
        if (isInvalid(nextLine)) {
            throw new IllegalArgumentException("올바른 수식을 입력해주세요.");
        }
        return new Formula(nextLine);
    }

    private static boolean isInvalid(String nextLine) {
        // 공백을 제거하고 사칙연산자(+,-,*,/)와 숫자만 포함하는 문자열인지 확인
        if (!nextLine.replaceAll(" ", "").matches("^[+\\-*/\\d]*$")) {
            return true;
        }
        return false;
    }

    public String getString() {
        return formula;
    }
}