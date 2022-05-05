package calculator;

public class Operand {
    private final int number;

    Operand(int number) {
        this.number = number;
    }

    Operand(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException(String.format("%s는 숫자가 아닙니다.", number));
        }
    }

    public int getNumber() {
        return this.number;
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
        return number;
    }
}
