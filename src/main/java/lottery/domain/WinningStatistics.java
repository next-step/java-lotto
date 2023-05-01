package lottery.domain;

import static java.util.Arrays.stream;

import java.util.Map;
import lottery.domain.constant.Rank;

public class WinningStatistics {


    private final Map<Rank, Integer> lotteriesByRank;

    public WinningStatistics(Map<Rank, Integer> lotteriesByRank) {
        fillEssentialKeys(lotteriesByRank);
        this.lotteriesByRank = lotteriesByRank;
    }

    private void fillEssentialKeys(Map<Rank, Integer> lotteriesByRank) {
        stream(Rank.values())
                .forEach(rank -> lotteriesByRank.putIfAbsent(rank, 0));
    }

    public int getWinningNumbers(Rank rank) {
        return lotteriesByRank.get(rank);
    }

    public int getTotalWinningPrice() {
        return stream(Rank.values()).mapToInt(
                rank -> lotteriesByRank.get(rank) * rank.getWinningMoney())
                .sum();
    }
}
