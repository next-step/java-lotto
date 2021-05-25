package lotto.enums;

public enum MessageEnum {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_ANSWER("지난 주 당첨 번호를 입력해 주세요."),
    LOTTO_PURCHASE("개를 구매했습니다."),
    RESULT("당첨 통계"),
    LINE("================================"),
    INCOME_PREFIX("총 수익률은"),
    INCOME_POSTFIX("입니다."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    BONUS_BALL_MESSAGE(", 보너스 볼 일치");


    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}