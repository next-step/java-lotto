package lotto.domain;

public class WinningInfo {

    private int count;
    private boolean isBonus;

    public WinningInfo(int count, boolean isBonus) {
        this.count = count;
        this.isBonus = isBonus;
    }

    public void countUp() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }
}
