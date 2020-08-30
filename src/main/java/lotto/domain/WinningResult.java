package lotto.domain;

import lotto.context.Rank;

import java.util.Map;

public class WinningResult {
    private final WinningPaper winningPaper;
    private WinningTable winningTable;

    public WinningResult(String winningLottoNumbers) {
        winningPaper = new WinningPaper(winningLottoNumbers);
        winningTable = new WinningTable();
    }

    public WinningPaper getWinningPaper() {
        return winningPaper;
    }

    public void setWinningTable(WinningTable winningTable) {
        this.winningTable = winningTable;
    }

    public Map<Rank, Integer> getMatchCountResult() {
        return winningTable.getMatchCountTable();
    }

    public Double calculationEarningsRate(Integer inputMoney) {
        return winningTable.calculationEarningsRate(inputMoney);
    }
}
