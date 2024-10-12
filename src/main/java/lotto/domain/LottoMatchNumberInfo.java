package lotto.domain;

public class LottoMatchNumberInfo {
    private final int count;
    private final boolean isBonus;

    public LottoMatchNumberInfo(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return isBonus;
    }

    public boolean isSecond() {
        return count == 5 && isBonus;
    }
}
