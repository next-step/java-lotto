package step2.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analyst {

    private final List<LottoNumber> targetData;

    private final LottoNumber winLottoNumber;

    private final BonusLottoNumber bonusLottoNumber;

    public Analyst(List<LottoNumber> targetData, LottoNumber winLottoNumber, BonusLottoNumber bonusLottoNumber) {
        this.targetData = targetData;
        this.winLottoNumber = winLottoNumber;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public CountsByRank getCountsByRank() {
        return new CountsByRank(groupByRank());
    }

    private Map<Rank, Long> groupByRank() {
        return this.targetData.stream()
                .map(lottoNumber -> {
                    int countOfMath = lottoNumber.compareMatch(winLottoNumber);
                    boolean matchBonus = lottoNumber.isInclude(bonusLottoNumber);
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
