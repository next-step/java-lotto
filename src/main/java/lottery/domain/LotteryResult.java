package lottery.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LotteryResult {

    public static final List<MatchedCountAndPrizePair> MATCHED_COUNT_AND_PRIZE_PAIRS = Arrays.asList(
        MatchedCountAndPrizePair.of(3, 5_000L),
        MatchedCountAndPrizePair.of(4, 50_000L),
        MatchedCountAndPrizePair.of(5, 1500_000L),
        MatchedCountAndPrizePair.of(6, 2_000_000_000L));

    private final Map<Integer, Long> matchedNumberCountAndWinningLotteryCount;
    private final float earningRate;

    private LotteryResult(Map<Integer, Long> matchedNumberCountAndWinningLotteryCount, final float earningRate) {
        this.matchedNumberCountAndWinningLotteryCount = Collections.unmodifiableMap(matchedNumberCountAndWinningLotteryCount);
        this.earningRate = earningRate;
    }

    public static LotteryResult from(Map<Integer, Long> matchedNumberCountAndWinningLotteryCount, final float earningRate) {
        return new LotteryResult(matchedNumberCountAndWinningLotteryCount, earningRate);
    }

    public static LotteryResult from(PurchasePrice purchasePrice, final LotteryTicket winningLottery, final LotteryTickets lotteryTickets) {
        final Map<Integer, Long> matchedNumberCountToWinningLotteryCount = lotteryTickets.tickets()
            .stream()
            .map(winningLottery::matchedCount)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final Long profit = MATCHED_COUNT_AND_PRIZE_PAIRS.stream()
            .filter(pair -> matchedNumberCountToWinningLotteryCount.containsKey(pair.matchedCount()))
            .map(pair -> pair.prize() * matchedNumberCountToWinningLotteryCount.get(pair.matchedCount()))
            .reduce(0L, Long::sum);

        final float earningRate = profit / (float) purchasePrice.price();

        return new LotteryResult(matchedNumberCountToWinningLotteryCount, earningRate);
    }

    public long winningLotteryCount(final int matchedCount) {
        return matchedNumberCountAndWinningLotteryCount.getOrDefault(matchedCount, 0L);
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
        return Float.compare(that.earningRate, earningRate) == 0 && Objects.equals(matchedNumberCountAndWinningLotteryCount,
            that.matchedNumberCountAndWinningLotteryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedNumberCountAndWinningLotteryCount, earningRate);
    }
}
