package lotto.domain;

public enum WinAmount {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    FAIL(0, 0, false);

    private int matchCount;
    private long reward;
    private boolean checkBonus;

    WinAmount(int matchCount, long reward, boolean checkBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.checkBonus = checkBonus;
    }

    public static WinAmount valueOfMatchCount(int matchCount, boolean isMatchBonus) {
        for (WinAmount i : WinAmount.values()) {
            if (matchCount == i.getMatchCount() && isMatchBonus(i.getCheckBonus(), isMatchBonus)) {
                return i;
            }
        }
        return FAIL;
    }

    private static boolean isMatchBonus(boolean checkBonus, boolean isMatchBonus){
        if(checkBonus){
            return isMatchBonus;
        }
        return true;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public long getReward() {
        return reward;
    }

    public boolean getCheckBonus(){
        return checkBonus;
    }
}
