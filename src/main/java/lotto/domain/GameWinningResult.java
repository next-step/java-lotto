package lotto.domain;

import lotto.common.WinningType;

public class GameWinningResult {
    private final WinningType winningType;
    private final int winningCount;

    public GameWinningResult(WinningType winningType, int winningCount) {
        this.winningType = winningType;
        this.winningCount = winningCount;
    }

    public WinningType getWinningType() {
        return winningType;
    }

    public int getWinningCount() {
        return winningCount;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null || this.getClass() == obj.getClass()) {
            return (((GameWinningResult)obj).winningCount == this.winningCount) &&
                    (((GameWinningResult)obj).winningType.equals(this.winningType));
        }
        return super.equals(obj);
    }
}
