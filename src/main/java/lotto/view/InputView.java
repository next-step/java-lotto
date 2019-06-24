package lotto.view;

import lotto.common.Inputer;
import lotto.common.Outer;
import lotto.domain.Lottos;

public class InputView {
    private final static String CASH_COUNT_ANSWER = "구입금액을 입력해 주세요.";
    private final static String WIN_NUMBER_ANSWER = "지난 주 당첨 번호를 입력해 주세요.(ex. 1,2,3,4,5,6)";
    private Inputer inputer;
    private Outer outer;
    
    public InputView(Inputer inputer, Outer outer) {
        this.inputer = inputer;
        this.outer = outer;
    }
    
    public void printCashAnswer() {
        outer.print(CASH_COUNT_ANSWER);
    }
    
    public void printWinNumberAnswer() {
        outer.print(WIN_NUMBER_ANSWER);
    }
    
    public int getUserInputCashPayment() {
        return inputer.inputNumber();
    }
    
    public String getUserInputWinNumber() {
        return inputer.inputString();
    }
}
