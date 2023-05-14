package lotto.view;

public enum Question {
    PRICE_QUESTION("구입금액을 입력해 주세요."),
    WON_NUMBER_QUESTION("지난 주 당첨 번호를 입력해주세요.");

    private final String questionValue;

    Question(String questionValue) {
        this.questionValue = questionValue;
    }

    public String getQuestionValue() {
        return questionValue;
    }
}
