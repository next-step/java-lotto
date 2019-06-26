package lotto.view;

import lotto.common.Inputer;
import lotto.common.Outer;

public class InputView {
    private final static String CASH_COUNT_ANSWER = "구입금액을 입력해 주세요.";
    private final static String WIN_NUMBER_ANSWER = "지난 주 당첨 번호를 입력해 주세요.(ex. 1,2,3,4,5,6)";
    private final static String WIN_BONUS_NUMBER_ANSWER = "보너스 볼을 입력해 주세요.";
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
    
    public WinNumbers getUserInputWinNumber() {    
        return new WinNumbers(getWinNumbers(), getBonasNumber());
    }
    
    private String getWinNumbers() {
        outer.print(WIN_NUMBER_ANSWER);
        return inputer.inputString();
    }
    
    private int getBonasNumber() {
        outer.print(WIN_BONUS_NUMBER_ANSWER);
        return inputer.inputNumber();
    }
}
