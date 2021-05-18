package calculator.domain;

public class CalculatorNumber {
    private Integer number;

    public CalculatorNumber(String number) {
        this.number = Integer.parseInt(number);

        if (this.number < 0) {
            throw new RuntimeException("음수를 갖을 수 없습니다.");
        }
    }

    public Integer getNumber() {
        return number;
    }
}
