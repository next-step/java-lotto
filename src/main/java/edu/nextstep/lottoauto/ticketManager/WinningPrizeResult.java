/*
 * WinningPrizeResult.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.ticketManager;

import edu.nextstep.lottoauto.ticket.Prize;

import java.util.Map;

public class WinningPrizeResult {

    private final Map<Prize, Integer> winningPrizeResult;

    public WinningPrizeResult(Map<Prize, Integer> winningPrizeResult) {
        this.winningPrizeResult = winningPrizeResult;
    }

    public Map<Prize, Integer> getWinningPrizeResult() {
        return winningPrizeResult;
    }
}
