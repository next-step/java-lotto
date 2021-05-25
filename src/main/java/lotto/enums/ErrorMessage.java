package lotto.enums;

public enum ErrorMessage {

    INVALID_NUMBER("숫자를 입력해주세요."),

    INVALID_PATTERN("형식에 맞게 입력해주세요.\n  예) 1,2:3 혹은 //;\\n1,2:3;4"),
    INSUFFICIENT_NUMBERS("숫자 6개를 입력해주세요."),
    NUMBER_OUT_OF_BOUNDS("1 ~ 45 사이의 숫자를 입력해주세요."),
    DUPLICATE_NUMBERS("중복된 숫자가 있습니다."),
    NULL_NUMBERS("숫자 리스트가 비었습니다."),

    CASH_OUT_OF_BOUNDS("지불 가능 금액은 1000원 ~ 1000000입니다."),

    TICKETS_OUT_OF_BOUNDS("티켓 수는 0보다 커야 합니다."),
    NULL_TICKETS("티켓 리스트가 비었습니다."),

    PRIZE_OUT_OF_BOUNDS("0 ~ 6 사이의 숫자를 입력하세요");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

}
