package lotto.domain;

public class Ticket {
    private final int maxCount;
    private int manualCount;
    private int autoCount;

    public Ticket(InputMoney inputMoney) {
        this.maxCount = inputMoney.getAvailableLottoSize();
        this.autoCount = inputMoney.getAvailableLottoSize();
    }

    public void setManualCount(int manualCount) {
        vlaidManualCount(manualCount);
        this.manualCount = manualCount;
        this.autoCount = maxCount - manualCount;
    }

    private void vlaidManualCount(int manualCount) {
        if (maxCount < manualCount) {
            throw new IllegalArgumentException("구입금액을 초과할 수 없습니다.");
        }
    }

    public int getMaxCount() {
        return maxCount;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
