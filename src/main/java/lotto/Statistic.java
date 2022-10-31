package lotto;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Statistic {
    private final Money money;
    private final Map<Winning, Integer> matching;
    private final double earningRate;

    public Statistic(Money money, Map<Winning, Integer> matching) {
        this.money = money;
        this.matching = matching;
        this.earningRate = calculateEarningRate();
    }

    private double calculateEarningRate() {
        Money earningSum = Money.of(0);
        for (Map.Entry<Winning, Integer> entry : matching.entrySet()) {
            earningSum = earningSum.plus(entry.getKey().getPrize().multiplyBy(entry.getValue()));
        }
        return earningSum.earningRate(money);
    }

    public double getEarningRate() {
        return earningRate;
    }

    public List<MatchingResult> getMatching() {
        return matching.entrySet()
                .stream()
                .map(e -> new MatchingResult(e.getKey(), e.getValue()))
                .sorted(comparing(r -> r.winning.getPrize().getMoney()))
                .collect(toList());
    }

    static class MatchingResult {
        private final Winning winning;
        private final int count;

        public MatchingResult(Winning winning, int count) {
            this.winning = winning;
            this.count = count;
        }

        public Winning getWinning() {
            return winning;
        }

        public int getCount() {
            return count;
        }
    }

}
