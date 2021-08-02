package edu.nextstep.lotto.step2.vo;

public class WinningNumber {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력 가능합니다.";

    private final int number;

    public WinningNumber(String number) {
        this.number = convertStringToNumber(number);
    }

    private int convertStringToNumber(String text) {
        int number;

        try {
            number = Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException(NUMBER_FORMAT_EXCEPTION);
        }

        return number;
    }

    public int getNumber() {
        return number;
    }
}
