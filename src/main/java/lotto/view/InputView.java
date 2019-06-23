package lotto.view;

import lotto.common.Inputer;
import lotto.common.Outer;

public class InputView {
    private final static String CASH_COUNT_ANSWER = "구입금액을 입력해 주세요.";
    private Inputer inputer;
    private Outer outer;
    
    public InputView(Inputer inputer, Outer outer) {
        this.inputer = inputer;
        this.outer = outer;
    }
    
    public void printCashAnswer() {
        outer.print(CASH_COUNT_ANSWER);
    }
    
    public int getUserInputCashPayment() {
        return inputer.inputNumber();
    }
}
