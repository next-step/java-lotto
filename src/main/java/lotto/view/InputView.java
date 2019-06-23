package lotto.view;

public abstract class InputView {
    public final static String CASH_COUNT_ANSWER = "구입금액을 입력해 주세요.";
    
    public void printCashAnswer() {
        print(CASH_COUNT_ANSWER);
    }
    
    abstract void print(String value);
}
