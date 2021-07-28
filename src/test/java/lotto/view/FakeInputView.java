package lotto.view;

import lotto.domain.Money;

public class FakeInputView implements InputView {
    private int intMoney;
    public FakeInputView(int intMoney) {
        this.intMoney = intMoney;
    }

    @Override
    public Money inputMoney() {
        return new Money(intMoney);
    }
}
