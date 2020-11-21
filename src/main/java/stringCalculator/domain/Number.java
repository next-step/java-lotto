package stringCalculator.domain;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(Object objNumber) {
        String number = replaceNullToZero(objNumber);
        validType(number);
        validNumber(number);
        this.number = Integer.parseInt(String.valueOf(number));
    }

    private String replaceNullToZero(Object objNumber) {
        String tempString = String.valueOf(objNumber);
        if (Objects.isNull(tempString) || tempString.isEmpty()) {
            return "0";
        }
        return tempString;
    }

    private void validType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값을 입력할 수 없습니다.");
        }
    }

    private void validNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException("숫자는 양수만 입력할 수 있습니다.");
        }
    }

    public static Number add(Object a, Object b) {
        if (!(a instanceof Number && b instanceof Number)) {
            return null;
        }
        return new Number(((Number) a).getNumber() + ((Number) b).getNumber());
    }

    int getNumber() {
        return number;
    }
}
