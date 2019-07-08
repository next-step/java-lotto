package lotto.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    Lotteries lotteries;
    LinkedHashSet<Number> winningNumbers;
    int bonusBall;

    public LottoResult(Lotteries lotteries, LinkedHashSet<Number> winningNumbers) {
        this.lotteries = lotteries;
        this.winningNumbers = winningNumbers;
    }

    public LottoResult(Lotteries lotteries, LinkedHashSet<Number> inputWinnerNumber, int bonusBall) {
        this.lotteries = lotteries;
        this.winningNumbers = inputWinnerNumber;
        this.bonusBall = bonusBall;
    }

    public List<Rank> getRank() {
        return lotteries.getLotteries()
                .stream()
                .map(this::getRank)
                .collect(Collectors.toList());
    }

    private Rank getRank(Lottery e) {
        Rank rank = Rank.valueOf(e.getWinningCount(winningNumbers), false);

        if (rank.getCountOfMatch() == 5 && e.isMatchBonusBall(bonusBall)) {
            return Rank.valueOf(e.getWinningCount(winningNumbers), true);
        }

        return rank;
    }

}
