package stringCalculator.domain;

public class Operand {

    private int value;

    public Operand(String number) {
        isEmpty(number);
        this.value = Integer.parseInt(number);
    }

    public int getValue() {
        return this.value;
    }

    private void isEmpty(String number) {
        if(number == null || number.isEmpty()) {
            throw new IllegalArgumentException("문자열이 올바르지 않습니다.");
        }
    }
}
