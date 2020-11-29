package StringAddCalculator;

import java.util.Objects;

public class Operand {

    private int number = 0;

    public Operand(int number) {
        this.number = number;
    }

    public Operand findOperand(String token) {
        int number = Integer.parseInt(token);

        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }

        return new Operand(this.number + number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operand operand = (Operand) o;
        return number == operand.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
