package game.lotto.model;

public class Amount {

    private int autoCount;
    private int manualCount;

    public Amount(Money money, int manualCount) {
        this.autoCount = computeAmount(money);
        this.manualCount = manualCount;
        if (isGraterManualCountThanAutoCount()) {
            throw new IllegalArgumentException("수동 갯수는 자동 갯수를 초과할 수 없습니다.");
        }
        this.autoCount -= this.manualCount;
    }

    public Amount(int autoCount, int manualCount) {
        this.autoCount = autoCount;
        this.manualCount = manualCount;
        if (isGraterManualCountThanAutoCount()) {
            throw new IllegalArgumentException("수동 갯수는 자동 갯수를 초과할 수 없습니다.");
        }
    }

    public Amount(Amount amount) {
        this.autoCount = amount.autoCount;
        this.manualCount = amount.manualCount;
    }

    private int computeAmount(Money money) {
        return money.getValue() / Money.LOTTO_PRICE;
    }

    private boolean isGraterManualCountThanAutoCount() {
        return this.manualCount > this.autoCount;
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    public int getManualCount() {
        return this.manualCount;
    }

    public boolean isSameAutoCount(int value) {
        return this.autoCount == value;
    }

    public int getTotalAmount() {
        return this.autoCount + this.manualCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return autoCount == amount.autoCount;
    }

    @Override
    public int hashCode() {
        return autoCount;
    }

    @Override
    public String toString() {
        return String.valueOf(this.autoCount);
    }
}
