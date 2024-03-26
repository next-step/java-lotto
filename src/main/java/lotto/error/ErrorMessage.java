package lotto.error;

public enum ErrorMessage {

    INVALID_INPUT_TYPE_INT("입력값의 타입이 정수형입니다. 문자열을 입력해주세요 "),

    INVALID_INPUT_EMPTY("입력값이 없습니다. 당첨 번호를 다시 입력해주세요. "),

    ILLEGAL_STATE("비정상 경로로 접근하였습니다. 다시 실행해주세요. "),

    UN_EXPECTED_ERROR("예기치 못한 예외가 발생되었습니다. 다시 실행해주세요. "),

    INVALID_FORMAT("당첨번호는 ', ' 로 구분되어야 합니다");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
