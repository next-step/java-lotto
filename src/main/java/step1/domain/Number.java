package step1.domain;

public class Number {

    private Integer number;

    public Number(Integer number) {
        checkBiggerThanZero(number);
        this.number = number;
    }

    public Number(String number) {
        checkBiggerThanZero(Integer.parseInt(number));
        checkNumeric(number);
        this.number = Integer.parseInt(number);
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (RuntimeException e) {
            throw new RuntimeException("숫자로 바뀔 수 없습니다.");
        }
    }

    private static void checkBiggerThanZero(Integer input) {
        Integer criteria = 0;
        if (input < criteria) {
            throw new RuntimeException("0보다 작은 값이 존재합니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }

    public Number add(Number num2) {
        return new Number(number + num2.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number numberTarget = (Number) o;
        return number != null ? number.equals(numberTarget.number) : numberTarget.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }
}
