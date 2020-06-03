package lotto.domain;

import java.util.List;

public class LottoResult {
    private final List<WinningSheet> winningSheets;

    public LottoResult(List<WinningSheet> winningSheets) {
        this.winningSheets = winningSheets;
    }

    public int sumAllPrize() {
        return winningSheets.stream()
                .mapToInt(WinningSheet::getPrice)
                .sum();
    }
}
