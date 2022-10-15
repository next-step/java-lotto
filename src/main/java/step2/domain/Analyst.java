package step2.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyst {

    private final List<LottoNumber> targetData;

    private final LottoNumber winLottoNumber;

    private final BonusNumber bonusNumber;

    public Analyst(List<LottoNumber> targetData, LottoNumber winLottoNumber, BonusNumber bonusNumber) {
        this.targetData = targetData;
        this.winLottoNumber = winLottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Long> getCountByRanks() {
        Map<Rank, Long> matchByCount = groupByRank();
        return putEmptyRank(matchByCount);
    }

    private Map<Rank, Long> putEmptyRank(Map<Rank, Long> matchByCount) {
        TreeMap<Rank, Long> countAllRanks = new TreeMap<>(matchByCount);
        Arrays.stream(Rank.values())
                .filter(rank -> !countAllRanks.containsKey(rank))
                .forEach(rank -> countAllRanks.put(rank, 0L));
        return countAllRanks;
    }

    private Map<Rank, Long> groupByRank() {
        return this.targetData.stream()
                .map(lottoNumber -> {
                    int countOfMath = lottoNumber.compareMatch(this.winLottoNumber);
                    boolean matchBonus = lottoNumber.isInclude(bonusNumber.getBonusNumber());
                    return Rank.valueOf(countOfMath, matchBonus);
                })
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                ));
    }

    public float revenueRatio(Map<Rank, Long> countByRank) {
        return ((float) totalRevenue(countByRank)) / targetData.size();
    }

    private long totalRevenue(Map<Rank, Long> countByRank) {
        return countByRank.entrySet().stream()
                .map(entries -> entries.getKey().getWinningMoney() * entries.getValue() / 1000)
                .reduce(0L, Long::sum);
    }
}
