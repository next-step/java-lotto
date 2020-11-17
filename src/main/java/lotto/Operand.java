package lotto;

public class Operand {
    private final Integer value;

    public Operand(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_CREATE_NEGATIVE_OPERAND);
        }
        this.value = number;
    }

    public Integer getValue() {
        return this.value;
    }
}
