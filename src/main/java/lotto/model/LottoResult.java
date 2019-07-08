package lotto.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private Lotteries lotteries;
    private LinkedHashSet<Number> winningNumbers;
    private Number bonusBall;

    public LottoResult(Lotteries lotteries, LinkedHashSet<Number> inputWinnerNumber, Number bonusBall) {
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

    private Rank getRank(Lottery lottery) {

        int matchingCount = lottery.getWinningCount(winningNumbers);

        if (isSecondRank(lottery, matchingCount)) {
            return Rank.valueOf(matchingCount, true);
        }

        return Rank.valueOf(matchingCount, false);
    }

    private boolean isSecondRank(Lottery lottery, int matchingCount) {
        return matchingCount == 5 && lottery.isMatchBonusBall(bonusBall);

    }


}
