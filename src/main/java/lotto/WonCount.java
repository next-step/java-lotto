package lotto;

public class WonCount {
    private int wonCount = 0;
    private boolean bonusWonCount = false;

    public void updateCount(SameNumberStateEnum sameNumberStateEnum) {
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_MAIN_NUMBER)
            wonCount++;
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_BONUS_NUMBER)
            bonusWonCount = true;
    }

    public int wonCount() {
        return wonCount;
    }

    public boolean bonusWonCount() {
        return bonusWonCount;
    }
}
