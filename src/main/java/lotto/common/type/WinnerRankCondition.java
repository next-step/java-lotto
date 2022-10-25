package lotto.common.type;

import java.util.Objects;

public class WinnerRankCondition {
    private final int correctNumberCount;
    private final boolean needBonus;

    public WinnerRankCondition(int correctNumberCount, boolean needBonus) {
        this.correctNumberCount = correctNumberCount;
        this.needBonus = needBonus;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerRankCondition that = (WinnerRankCondition) o;
        return correctNumberCount == that.correctNumberCount && needBonus == that.needBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctNumberCount, needBonus);
    }

    public static WinnerRankCondition missCountFrom(int correctNumberCount, boolean needBonus){
        if(isMiss(correctNumberCount)){
            correctNumberCount = 0;
        }
        return new WinnerRankCondition(correctNumberCount, needBonus);
    }

    private static boolean isMiss(int correctNumberCount) {
        return correctNumberCount == 1 || correctNumberCount == 2;
    }
}
