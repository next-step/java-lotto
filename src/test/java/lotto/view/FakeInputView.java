package lotto.view;

import lotto.view.InputView;

public class FakeInputView implements InputView {
    private final long longMoney;
    private final String prizeNumbers;
    public FakeInputView(long longMoney, String prizeNumbers) {
        this.longMoney = longMoney;
        this.prizeNumbers = prizeNumbers;
    }

    @Override
    public long inputMoney() {
        return longMoney;
    }

    @Override
    public String inputPrizeNumbers() {
        return prizeNumbers;
    }
}
