package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultStats {

    private final List<LottoPrize> prizesOfUser;

    public ResultStats(final List<Integer> matchingCountsByTicket) {
        this.prizesOfUser = matchingCountsByTicket.stream()
                .map(LottoPrize::from)
                .collect(Collectors.toList());
    }

    public List<Integer> countsOfPrizes() {
        return Arrays.stream(LottoPrize.values())
                .map(prize -> (int) prizesOfUser.stream()
                        .filter(prizeOfUser -> prizeOfUser.matchCount() == prize.matchCount())
                        .count()
                ).collect(Collectors.toList());
    }

    public double returnOnInvestment(int price) {
        return prizesOfUser.stream().mapToDouble(LottoPrize::amount).sum() / (double) price;
    }
}
