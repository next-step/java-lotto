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

    private final List<SixLotteryNumbers> lotteries;

    public Lotteries(int plays) {
        this(lotteriesByPlayNumbers(plays));
    }

    public Lotteries(List<SixLotteryNumbers> lotteries) {
        this.lotteries = lotteries;
    }

    private static List<SixLotteryNumbers> lotteriesByPlayNumbers(int plays) {
        return range(0, plays)
                .mapToObj(play -> new SixLotteryNumbers())
                .collect(Collectors.toList());
    }

    public int size() {
        return this.lotteries.size();
    }

    public List<SixLotteryNumbers> immutableGetLotteries() {
        return unmodifiableList(this.lotteries);
    }

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + lotteries +
                '}';
    }

    public Map<Rank, Integer> getDividedLotteriesByRank(Set<LotteryNumber> winningNumbers) {
        Map<Rank, Integer> dividedLotteriesByRank = new HashMap<>();

        return dividedLotteriesByRank;
    }

}
