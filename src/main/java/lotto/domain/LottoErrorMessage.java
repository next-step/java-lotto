package lotto.domain;

public enum LottoErrorMessage {
    UNDER_MIN_INPUT_MONEY(0, "로또 최소 구매 금액은 1000원입니다."),
    ILLEGAL_INPUT_MONEY(1, "구매 금액을 숫자로 입력해주세요."),
    NOT_PRIZE_UNIT(2, "미당첨 입니다."),
    ILLEGAL_WINNING_NUMBER(3, "지난 당첨번호를 쉼표로 구분된 6개의 숫자(1~45)로 입력하세요."),
    ILLEGAL_BONUS_NUMBER(4, "보너스 번호를 1개의 숫자(1~45)로 입력하세요."),
    ILLEGAL_INPUT_MANUAL_TICKET(5, "수동으로 구매할 로또 수를 숫자로 입력해주세요."),
    ILLEGAL_MANUAL_TICKET_NUMBER(6, "수동으로 구매할 로또를 쉼표로 구분된 6개의 숫자(1~45)로 입력하세요."),
    OVER_MANUAL_TICKET_COUNT(7, "구매 금액보다 많은 수의 티켓을 발행할 수 없습니다.");

    private int code;
    private String errorMessage;

    LottoErrorMessage(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

}
