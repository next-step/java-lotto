package lotto;

public class SameNumberCountInALotto {
    private int sameNumberCount = 0;
    private boolean isBonusWon = false;

    public void updateCount(SameNumberStateEnum sameNumberStateEnum) {
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_MAIN_NUMBER)
            sameNumberCount++;
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_BONUS_NUMBER)
            isBonusWon = true;
    }

    public int wonCount() {
        return sameNumberCount;
    }

    public boolean isBonusWon() {
        return isBonusWon;
    }
}
