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

    public CountsByRank getCountsByRank() {
        CountsByRank countsByRank = new CountsByRank(groupByRank());
        return countsByRank.mergeEmptyRank();
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

    public float revenueRatio(CountsByRank countsByRank) {
        return ((float) countsByRank.totalRevenue()) / targetData.size();
    }
}
