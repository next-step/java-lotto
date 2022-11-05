package lotto.constant;

public enum Question {
    PRICE("구입금액을 입력해 주세요."),
    LAST_WEEK_LOTTO_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    MANUAL_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    MANUAL_NUMBER("수동으로 구매할 번호를 입력해 주세요.");

    private final String question;

    Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }
}
