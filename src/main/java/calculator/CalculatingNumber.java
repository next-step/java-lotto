package calculator;

public class CalculatingNumber {

    private final int number;

    public CalculatingNumber(String number) {
        try {
            this.number = validateNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new RuntimeException("양의 정수가 아닙니다. 입력값을 확인해 주세요.");
        }
    }

    private int validateNumber(int calculatingNumber) {
        if(calculatingNumber < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return calculatingNumber;
    }

    public int getNumber() {
        return number;
    }
}
