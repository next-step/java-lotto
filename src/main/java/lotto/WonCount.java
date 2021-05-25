package lotto;

public class WonCount {
    private int wonCount = 0;
    private boolean isBonusWon = false;

    public void updateCount(SameNumberStateEnum sameNumberStateEnum) {
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_MAIN_NUMBER)
            wonCount++;
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_BONUS_NUMBER)
            isBonusWon = true;
    }

    public int wonCount() {
        return wonCount;
    }

    public boolean isBonusWon() {
        return isBonusWon;
    }
}
