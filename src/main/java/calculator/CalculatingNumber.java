package calculator;

public class CalculatingNumber {

    private final int number;

    public CalculatingNumber(String number) {
        this.number = parseInt(number);
    }

    private int parseInt(String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if(parsedNumber < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            return parsedNumber;
        } catch (NumberFormatException e) {
            throw new RuntimeException("양의 정수가 아닙니다. 입력값을 확인해 주세요.");
        }
    }

    public int getNumber() {
        return number;
    }
}
