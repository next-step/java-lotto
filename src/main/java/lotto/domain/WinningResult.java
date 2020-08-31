package lotto.domain;

import lotto.context.Rank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private LottoPaper winningPaper;
    private WinningTable winningTable;

    public WinningResult(String winningLottoNumbers) {
        winningPaper = new LottoPaper(Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(integer -> new LottoNum(integer))
                .collect(Collectors.toList()));
        winningTable = new WinningTable();
    }

    public LottoPaper getWinningPaper() {
        return winningPaper;
    }

    public void setWinningTable(WinningTable winningTable) {
        this.winningTable = winningTable;
    }

    public Map<Rank, Integer> getMatchCountResult() {
        return winningTable.getMatchCountTable();
    }

    public int getTotalWinningMoney() {
        return winningTable.getTotalWinningMoney();
    }
}
