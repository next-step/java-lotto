package calculator;

import java.util.Objects;

public class Number {
    private static final int MIN = 0;
    static final int DEFAULT = 0;
    private int number;

    Number(int number) {
        if(number < 0){
            throw new IllegalArgumentException("숫자는 " + MIN + "보다 커야합니다.");
        }
        this.number = number;
    }

    public static Number of(String number) {
        int result = 0;
        try{
            result = Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 문자열 입니다.");
        }

        return new Number(result);
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    public Number add(Number number) {
        return new Number(this.number + number.number);
    }
}
