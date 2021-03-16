package step1.domain;

public class NaturalNumber {

    public static final int MIN_WIDTH = 0;

    private final int naturalNumber;

    public NaturalNumber(String text) {
        int number = Integer.parseInt(text);
        minusValid(number);
        this.naturalNumber = number;
    }

    private void minusValid(int number) {
        if (number < MIN_WIDTH) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int getNumber() {
        return naturalNumber;
    }
}
