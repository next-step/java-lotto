package lotto.view;

import static lotto.view.common.Answers.*;
import lotto.common.Inputer;
import lotto.common.Outer;
import lotto.view.data.LottoBuyingInfo;
import lotto.view.data.WinNumbers;

public class InputView {
    private Inputer inputer;
    private Outer outer;
    
    public InputView(Inputer inputer, Outer outer) {
        this.inputer = inputer;
        this.outer = outer;
    }
    
    public LottoBuyingInfo getLottoBuyingInfo() {
        return new LottoBuyingInfo(getUserInputCashPayment(), getUserInputSelfInputNumberCount());
    }
    
    private int getUserInputCashPayment() {
        outer.print(CASH_PAYMENT.getAnswer());
        return inputer.inputNumber();
    }
    
    private int getUserInputSelfInputNumberCount() {
        outer.print(SELF_INPUT_COUNT.getAnswer());
        return inputer.inputNumber();
    }
    
    // 수동로또번호입력받기
    
    
    
    
    public WinNumbers getUserInputWinNumber() {    
        return new WinNumbers(getWinNumbers(), getBonusNumber());
    }
    
    private String getWinNumbers() {
        outer.print(WIN_NUMBER.getAnswer());
        return inputer.inputString();
    }
    
    private int getBonusNumber() {
        outer.print(WIN_BONUS_NUMBER.getAnswer());
        return inputer.inputNumber();
    }
}
