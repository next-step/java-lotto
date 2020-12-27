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
     * @param luckyLotto 당첨 번호
     * @param bonusNumber 보너스 번호
     * @return 당첨 통계
     */
    public LottoStatistic makeStatistic(Lotto luckyLotto, LottoNumber bonusNumber) {
        LottoStatistic statistic = new LottoStatistic();
        for (Lotto lotto : lottoList) {
            int matchingCount = lotto.draw(luckyLotto);
            boolean matchBonus = lotto.drawBonus(matchingCount, bonusNumber);
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