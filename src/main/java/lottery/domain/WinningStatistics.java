package lottery.domain;

import static java.util.Arrays.stream;

import java.util.Map;
import lottery.domain.constant.Rank;

public class WinningStatistics {

    private static final String NOT_CONTAINS_ALL_KEYS = "당첨을 판별 할 수 있는 키 정보가 없습니다.";

    private final Map<Rank, Integer> lotteriesByRank;

    public WinningStatistics(Map<Rank, Integer> lotteriesByRank) {
        if(notContainsAllEssentialKeys(lotteriesByRank)) {
            throw new IllegalArgumentException(NOT_CONTAINS_ALL_KEYS);
        }
        this.lotteriesByRank = lotteriesByRank;
    }

    private boolean notContainsAllEssentialKeys(Map<Rank, Integer> lotteriesByRank) {
        return !stream(Rank.values())
                .allMatch(lotteriesByRank::containsKey);
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
