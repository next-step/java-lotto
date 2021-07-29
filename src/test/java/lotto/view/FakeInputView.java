package lotto.view;

public class FakeInputView implements InputView {
    private final long intMoney;
    private final String prizeNumbers;
    public FakeInputView(long intMoney, String prizeNumbers) {
        this.intMoney = intMoney;
        this.prizeNumbers = prizeNumbers;
    }

    @Override
    public long inputMoney() {
        return intMoney;
    }

    @Override
    public String inputPrizeNumbers() {
        return prizeNumbers;
    }
}
