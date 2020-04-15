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

        if (tempCount < 0) {
            throw new RuntimeException("입력값은 음수가 될 수 없습니다.");
        } else if (tempCount > amount.getAmount() / 1000) {
            throw new RuntimeException("수동 구매할 수량은 구입금액을 넘을 수 없습니다.");
        }

        this.manualCount = tempCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }
}
