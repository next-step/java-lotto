package lotto.view.common;

public enum Answers {
    CASH_PAYMENT("구입금액을 입력해 주세요."),
    SELF_INPUT_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    
    SELF_INPUT_NUMBER("수동으로 구매할 번호를 입력해 주세요."),
    
    WIN_NUMBER("지난 주 당첨 번호를 입력해 주세요.(ex. 1,2,3,4,5,6)"),
    WIN_BONUS_NUMBER("보너스 볼을 입력해 주세요.");
    
    private String answer;
    
    Answers(String answer) {
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer;
    }
}
