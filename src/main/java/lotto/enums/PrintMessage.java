package lotto.common;

public enum PrintMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_ANSWER("지난 주 당첨 번호를 입력해 주세요."),
    LOTTO_PURCHASE("개를 구매했습니다."),
    RESULT("당첨 통계"),
    LINE("================================"),
    INCOME_PREFIX("총 수익률은"),
    INCOME_POSTFIX("입니다."),
    ANSWER_UNIT("개");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public void println() {
        System.out.println(message);
    }

    public void println(int amount) {
        System.out.println(amount + message);
    }
}
