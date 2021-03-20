package step1;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(String formula) {
        this.number = parserInt(formula);
        validationCheck(this.number);
    }

    public int parserInt(String formula) {
        if (isBlankOrNull(formula)) {
            return 0;
        }
        return convertStringToNumber(formula);
    }

    public int convertStringToNumber(String formula) {
        int result;
        try {
            result = Integer.parseInt(formula);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자이외의 문자는 입력할 수 없습니다.");
        }
        return result;
    }

    public void validationCheck(int number) {
        if (isNegativeNumber(number)) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    public boolean isBlankOrNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
