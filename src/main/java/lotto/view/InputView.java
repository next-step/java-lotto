package lotto.view;

import static lotto.view.common.Answers.*;
import lotto.common.Inputer;
import lotto.common.Outer;
import lotto.domain.SelfInputCount;
import lotto.view.data.WinNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private Inputer inputer;
    private Outer outer;
    
    public InputView(Inputer inputer, Outer outer) {
        this.inputer = inputer;
        this.outer = outer;
    }
    
    public int getInputCashPayment() {
        outer.print(CASH_PAYMENT.getAnswer());
        return inputer.inputNumber();
    }
    
    public int getInputSelfInputCount() {
        outer.print(SELF_INPUT_COUNT.getAnswer());
        return inputer.inputNumber();
    }
    
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
    
    public List<String> getInputSelfLottoNumbers(final SelfInputCount selfInputCount) {
        outer.print(SELF_INPUT_NUMBER.getAnswer());
        return IntStream.range(0, selfInputCount.getSelfInputCount())
            .mapToObj(i -> inputer.inputString())
            .collect(Collectors.toList());
    }
}
