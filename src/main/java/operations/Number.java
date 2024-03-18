package operations;

public class Number {
    private int number;

    public Number(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("정수를 입력하세요");
        }
        this.number = Integer.parseInt(number);
    }

    public int number() {
        return this.number;
    }
}
