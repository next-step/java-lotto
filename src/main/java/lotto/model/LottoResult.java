package lotto.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    Lotteries lotteries;
    LinkedHashSet<Number> winningNumbers;

    public LottoResult(Lotteries lotteries, LinkedHashSet<Number> winningNumbers) {
        this.lotteries = lotteries;
        this.winningNumbers = winningNumbers;
    }

    public List<Rank> getRank() {
        return lotteries.getLotteries()
                .stream()
                .map(e -> Rank.valueOf(e.getWinningCount(winningNumbers), false))
                .collect(Collectors.toList());
    }

}
