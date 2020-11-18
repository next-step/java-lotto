package lotto;

public enum LottoErrorMessage {
    UNDER_MIN_INPUT_MONEY(0, "로또 최소 구매 금액은 1000원입니다."),
    ILLEGAL_INPUT_MONEY(1, "구매 금액을 숫자로 입력해주세요."),
    NOT_PRIZE_UNIT(2, "미당첨 입니다."),
    ILLEGAL_WINNING_NUMBER(3, "지난 당첨번호를 쉼표로 구분된 6개의 숫자로 입력하세요.");

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
