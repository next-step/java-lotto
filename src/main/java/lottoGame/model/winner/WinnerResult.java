package lottoGame.model.winner;

import static java.lang.Math.floor;
import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

public class WinnerResult {

    private final List<WinStandard> winResults;

    public WinnerResult() {
        this(new ArrayList<>());
    }

    public WinnerResult(List<WinStandard> winResults) {
        this.winResults = winResults;
    }

    public void addWinResult(WinStandard winStandard) {
        if (isNull(winStandard)) {
            return;
        }

        if (winStandard.isNothing()) {
            return;
        }

        winResults.add(winStandard);
    }

    public int findWinCount(WinStandard winStandard) {
        long count = this.winResults.stream()
                .filter(winResult -> winResult.equals(winStandard))
                .count();

        return Long.valueOf(count).intValue();
    }

    public double calculateRateOfReturn(int buyPrice) {
        int totalWinReturn = this.winResults.stream()
                .mapToInt(WinStandard::returnOfWin)
                .sum();

        double rawRate = (double) totalWinReturn / buyPrice * 100;
        return floor(rawRate) / 100.0;
    }
}
