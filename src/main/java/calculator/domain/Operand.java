package calculator.domain;

import java.util.Objects;

class Operand {
    private static final int DEFAULT_NUMBER = 0;

    private final int number;

    public Operand() {
        this.number = DEFAULT_NUMBER;
    }

    Operand(String number) {
        this.number = Integer.parseInt(number);
        validate();
    }

    private void validate() {
        if (isNegativeNumber()) {
            throw new IllegalArgumentException("피연산자는 음수가 될 수 없습니다.");
        }
    }

    private boolean isNegativeNumber() {
        return this.number < 0;
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
