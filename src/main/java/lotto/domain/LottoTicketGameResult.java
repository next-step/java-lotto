package lotto.domain;

import lotto.common.WinningType;

public class LottoTicketGameResult {
    private final WinningType winningType;
    private final int winningCount;

    public LottoTicketGameResult(WinningType winningType, int winningCount) {
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
            return (((LottoTicketGameResult)obj).winningCount == this.winningCount) &&
                    (((LottoTicketGameResult)obj).winningType.equals(this.winningType));
        }
        return super.equals(obj);
    }
}
