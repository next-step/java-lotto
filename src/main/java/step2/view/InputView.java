package step2.view;

import step2.model.LottoException;

public class InputView {

    public void setAmount(String amount) {
        LottoException.isBlank(amount);
        LottoException.isDigit(amount);
    }
}
