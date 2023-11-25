package lotto.model;

public class StringToInteger {
    private final Integer number;

    public StringToInteger(String input) {
        checkConvertToInteger(input);
        this.number = Integer.parseInt(input);
    }

    private void checkConvertToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 변환할 수 없는 input입니다.");
        }
    }
    public int number(){
        return this.number;
    }
}
