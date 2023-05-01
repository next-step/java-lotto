package lottery.domain;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.IntStream.range;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lottery.domain.constant.Rank;

public class Lotteries {

    private static final int FIRST_WINNING_COUNT = 1;

    private final List<Lottery> lotteries;

    public Lotteries(int plays) {
        this(lotteriesByPlayNumbers(plays));
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    private static List<Lottery> lotteriesByPlayNumbers(int plays) {
        return range(0, plays)
                .mapToObj(play -> new Lottery())
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lotteries.size();
    }

    public List<Lottery> immutableGetLotteries() {
        return unmodifiableList(this.lotteries);
    }

    public Map<Rank, Integer> statisticsByRank(Set<LotteryNumber> winningNumbers) {
        Map<Rank, Integer> statisticsByRank = new HashMap<>();
        for(Lottery lottery: this.lotteries) {
            countUpByRank(statisticsByRank, lottery.intersectionSize(winningNumbers));
        }
        return statisticsByRank;
    }

    private void countUpByRank(Map<Rank, Integer> statisticsByRank, int intersectionSize) {
        Rank rank = Rank.getRankByCountOfMatch(intersectionSize);
        if(statisticsByRank.containsKey(rank)) {
            statisticsByRank.put(rank, statisticsByRank.get(rank) + 1);
            return;
        }
        statisticsByRank.put(rank, FIRST_WINNING_COUNT);
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + lotteries +
                '}';
    }


}
