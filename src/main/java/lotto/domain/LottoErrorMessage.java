package lotto.domain;

import static lotto.domain.LottoGameConfig.*;

public enum LottoErrorMessage {
    UNDER_MIN_INPUT_MONEY(0, "로또 최소 구매 금액은 "+LOTTO_GAME_MONEY_UNIT+"원입니다."),
    ILLEGAL_INPUT_MONEY(1, "구매 금액을 숫자로 입력해주세요."),
    NOT_PRIZE_UNIT(2, "미당첨 입니다."),
    ILLEGAL_LOTTO_NUMBER(3, "로또번호를 "+MIN_LOTTO_NUMBER+"에서 "+MAX_LOTTO_NUMBER+" 사이의 숫자로 입력해주세요."),
    ILLEGAL_INPUT_MANUAL_TICKET(4, "수동으로 구매할 로또 수를 숫자로 입력해주세요."),
    OVER_MANUAL_TICKET_COUNT(5, "구매 금액보다 많은 수의 티켓을 발행할 수 없습니다."),
    ILLEGAL_LOTTO_NUMBER_COUNT(6, "로또를 "+LOTTO_TICKET_NUMBER_COUNT+"개의 숫자로 입력해주세요."),
    ILLEGAL_BONUS_NUMBER(7, "보너스번호를 "+MIN_LOTTO_NUMBER+"에서 "+MAX_LOTTO_NUMBER+" 사이의 숫자 1개로 입력해주세요.");

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
