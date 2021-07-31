package edu.nextstep.lotto.step1.vo;

public class TokenNumber {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력 가능합니다.";
    private static final String CAN_NOT_NEGATIVE_EXCEPTION = "음수는 사용할 수 없습니다.";

    private final int number;

    public TokenNumber(String token) {
        this.number = convertStringToNumber(token);
    }

    private int convertStringToNumber(String token) {
        int number;

        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException(NUMBER_FORMAT_EXCEPTION);
        }

        if (number < 0) {
            throw new RuntimeException(CAN_NOT_NEGATIVE_EXCEPTION);
        }

        return number;
    }

    public int getNumber() {
        return number;
    }
}
