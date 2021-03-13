package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoStatistics {

    private List<Lotto> lottoList;

    public Map<Integer, List<Rank>> getLottoRank(Lottos lottos, List<Integer> winNumber) {
        List<Rank> lottoList = lottos.staticsOfMatch(winNumber);
        Map<Integer, List<Rank>> statistics = statistics(lottoList);
        return statistics;
    }

    public Map<Integer, List<Rank>> statistics(List<Rank> matchResult) {
        return matchResult.stream()
                .collect(Collectors.groupingBy(Rank::getCountOfMatch));
    }
}
