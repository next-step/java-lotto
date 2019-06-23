package step1;

public class Number {
    private final Integer number;

    Number(String number) {
        this.number = parseNumber(number);
        assertNegativeNumber();
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number 타입으로 변경할 수 없는 문자입니다.", e);
        }
    }

    private void assertNegativeNumber() {
        if (this.number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
