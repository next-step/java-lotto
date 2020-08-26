package lotto.domain;

import lotto.context.Rank;

import java.util.List;
import java.util.Map;

public class WinningResult {
    private final WinningPaper winningPaper;
    private final WinningTable winningTable;


    public WinningResult(String winningLottoNumbers) {
        winningPaper = new WinningPaper(winningLottoNumbers);
        winningTable = new WinningTable();
    }

    public Map<Rank, Integer> getMatchCountResult() {
        return winningTable.getMatchCountTable();
    }

    public void setAutoIncrement(List<Integer> lottoNumbers) {
        Integer matchCount = winningPaper.getMatchCount(lottoNumbers);
        if (matchCount < 3) {
            return;
        }
        winningTable.setAutoIncrementMatchCountResult(matchCount);
    }

    public Double calculationEarningsRate(Integer inputMoney) {
        return winningTable.calculationEarningsRate(inputMoney);
    }
}
