package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    /**
     * 당첨 통계 만들기
     * @param winningLotto 우승 로또
     * @return 당첨 통계
     */
    public LottoStatistic makeStatistic(WinningLotto winningLotto) {
        LottoStatistic statistic = new LottoStatistic();
        for (Lotto lotto : lottoList) {
            int matchingCount = winningLotto.getMatchingCount(lotto);
            boolean matchBonus = winningLotto.getMatchBonus(lotto);
            LottoRank rank = LottoRank.valueOf(matchingCount, matchBonus);
            statistic.putLottoStatisticMap(rank);
        }
        return statistic;
    }

    public List<String> toStringLottos() {
        return lottoList.stream()
                .map(Lotto::toStringNumbers)
                .collect(Collectors.toList());
    }

}