package lotto.domain;

public class WinningCount {
    private int winningCount;
    private boolean bonus;

    public WinningCount() {
        this.winningCount = 0;
        this.bonus = false;
    }

    public WinningCount(int winningCount) {
        this.winningCount = winningCount;
        this.bonus = false;
    }

    public WinningCount(int winningCount, boolean bonus) {
        this.winningCount = winningCount;
        this.bonus = bonus;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonus() {
        return bonus;
    }
    public void plus(){
        this.winningCount++;
    }

    public void plus(boolean isSameBonus){
        this.winningCount++;
        this.bonus = isSameBonus;
    }
}
