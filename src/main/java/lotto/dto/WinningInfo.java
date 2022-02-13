package lotto.dto;

public class WinningInfo {

    private final int count;
    private final boolean hasBonus;

    public WinningInfo(int count, boolean hasBonus) {
        this.count = count;
        this.hasBonus = hasBonus;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
