package lotto.view;

public enum QuestionType {
    MONEY_FOR_BUY("구입금액을 입력해 주세요."),
    LAST_WEEKEND_PRIZE("지난 주 당첨 번호를 입력해 주세요.");

    private String question;

    QuestionType(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }
}
