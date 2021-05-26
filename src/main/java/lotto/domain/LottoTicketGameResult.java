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
}
