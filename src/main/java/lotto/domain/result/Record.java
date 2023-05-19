package lotto.domain.result;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Record {

    private final Map<Rank, Integer> rankMap;

    public Record(Map<Rank, Integer> rankMap) {
        this.rankMap = rankMap;
    }

    public Map<Rank, Integer> getRecord() {
        return new EnumMap<>(rankMap);
    }

    public static Record extractRecord(LottoBundle lottoBundle, WinNumber winNumber) {
        List<Lotto> lottoList = lottoBundle.unfoldLottoBundle();

        Map<Rank, Integer> recordMap = lottoList.stream()
                .map(winNumber::matchRank)
                .filter(rank -> rank.getMatchingCount() >= 3)
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum, () -> new EnumMap<>(Rank.class)));

        return new Record(recordMap);
    }

}