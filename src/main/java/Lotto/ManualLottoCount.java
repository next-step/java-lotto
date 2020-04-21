package Lotto;

public class ManualLottoCount {

    private int manualCount;

    public ManualLottoCount() { }
    public ManualLottoCount(String manualCountStr, Amount amount) {
        int tempCount = 0;
        try {
            tempCount = Integer.parseInt(manualCountStr);
        } catch (NumberFormatException e) {
            e.addSuppressed(new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다."));
        }

        isMinus(tempCount);
        isCorrectCount(tempCount, amount);

        this.manualCount = tempCount;
    }

    private void isMinus(int count) {
        if (count < 0) {
            throw new RuntimeException("입력값은 음수가 될 수 없습니다.");
        }
    }

    private void isCorrectCount(int count,  Amount amount) {
        if (count > amount.getAmount() / 1000) {
            throw new RuntimeException("수동 구매할 수량은 구입금액을 넘을 수 없습니다.");
        }
    }

    public int getManualCount() {
        return this.manualCount;
    }
}
