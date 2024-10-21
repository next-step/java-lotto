package lotto.domain;

public class LottoResult {
    private final boolean hasBonusNumber;
    private final int equalNumberCount;

    public LottoResult(boolean hasBonusNumber, int equalNumberCount) {
        this.hasBonusNumber = hasBonusNumber;
        this.equalNumberCount = equalNumberCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getEqualNumberCount() {
        return equalNumberCount;
    }
}
