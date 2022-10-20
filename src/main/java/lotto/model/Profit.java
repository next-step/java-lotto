package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Profit {

    private final WinningLotto winningLotto;

    public Profit(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Long> getLotteriesRank(List<Lotto> allLotteries) {
        return allLotteries.stream()
                .map(winningLotto::match)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static double getReturnRate(Map<Rank, Long> lotteriesRank, int purchaseAmount) {
        double totalAmount = lotteriesRank.entrySet().stream()
                .mapToLong((rank) -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum();

        return totalAmount / purchaseAmount;
    }
}
