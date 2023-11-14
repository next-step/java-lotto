package stringCalculator.utils;

/*
메시지 관련 정보를 한 클래스에 담아서 꺼내쓰고싶은데 그때도 이넘을 사용해도 괜찮을지
 */

public enum Message {
    QUESTION_FOR_CALCULATOR("계산을 원하는 연산을 입력해주세요.(숫자와 사칙연산 사이에는 반드시 빈 공백이 포함되어야합니다)"),
    INPUT_DATA_NULL_OR_BLACK("아무것도 입력하지 않을 경우 연산을 수행할 수 없습니다."),
    CALCULATOR_OPERATOR_EXCEPTION("사칙연산을 제외한 문자는 계산할 수 없습니다."),
    BLANK(" ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
