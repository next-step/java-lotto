package lotto.view;

public class FakeInputView implements InputView {
    private final int intMoney;
    private final String prizeNumbers;
    public FakeInputView(int intMoney, String prizeNumbers) {
        this.intMoney = intMoney;
        this.prizeNumbers = prizeNumbers;
    }

    @Override
    public int inputMoney() {
        return intMoney;
    }

    @Override
    public String inputPrizeNumbers() {
        return prizeNumbers;
    }
}
