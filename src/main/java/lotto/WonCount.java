package lotto;

public class WonCount {
    private int wonCount = 0;
    private int bonusWonCount = 0;

    public void updateCount(SameNumberStateEnum sameNumberStateEnum) {
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_MAIN_NUMBER)
            wonCount++;
        if (sameNumberStateEnum == SameNumberStateEnum.SAME_BONUS_NUMBER)
            bonusWonCount++;
    }

    public int wonCount() {
        return wonCount;
    }

    public int bonusWonCount() {
        return bonusWonCount;
    }
}
