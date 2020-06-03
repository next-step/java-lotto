package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<WinningSheet> winningSheets;

    public LottoResult(List<WinningSheet> winningSheets) {
        this.winningSheets = winningSheets;
    }

    public int sumAllPrize() {
        return winningSheets.stream()
                .mapToInt(WinningSheet::getPrize)
                .sum();
    }

    public int countPrize(WinningSheet targetSheet) {
        return (int) winningSheets.stream()
                .filter(winningSheet -> winningSheet.equals(targetSheet))
                .count();
    }
}
