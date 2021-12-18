package lottery.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LotteryResult {

    private final Map<Rank, Long> rankToWinningLotteryCount;
    private final float earningRate;

    private LotteryResult(Map<Rank, Long> rankToWinningLotteryCount, final float earningRate) {
        this.rankToWinningLotteryCount = Collections.unmodifiableMap(rankToWinningLotteryCount);
        this.earningRate = earningRate;
    }

    public static LotteryResult of(Map<Rank, Long> matchedNumberCountAndWinningLotteryCount, final float earningRate) {
        return new LotteryResult(matchedNumberCountAndWinningLotteryCount, earningRate);
    }

    public static LotteryResult of(final PurchasePrice purchasePrice, WinningLotteryNumbers winningLotteryNumbers,
        final LotteryTickets lotteryTickets) {
        final Map<Rank, Long> rankToWinningLotteryCount = lotteryTickets.tickets()
            .stream()
            .map(winningLotteryNumbers::matchedRank)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final Long profit = Arrays.stream(Rank.values())
            .filter(rankToWinningLotteryCount::containsKey)
            .map(rank -> rank.getWinningMoney() * rankToWinningLotteryCount.get(rank))
            .reduce(0L, Long::sum);

        final float earningRate = profit / (float) purchasePrice.price();

        return new LotteryResult(rankToWinningLotteryCount, earningRate);
    }

    public long winningLotteryCount(final Rank rank) {
        return rankToWinningLotteryCount.getOrDefault(rank, 0L);
    }

    public float getEarningRatio() {
        return earningRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LotteryResult that = (LotteryResult) o;
        return Float.compare(that.earningRate, earningRate) == 0 && Objects.equals(rankToWinningLotteryCount,
            that.rankToWinningLotteryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankToWinningLotteryCount, earningRate);
    }
}
