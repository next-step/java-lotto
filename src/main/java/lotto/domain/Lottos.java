package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private static final int INCREMENT_VALUE = 1;

    private List<LottoNumbers> lottos;

    public Lottos(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoRank, Integer> getWinningStatistics(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> LottoRank.findLottoRankByLottoCount(lotto.getCountOfMatchLottoNumber(winningLottoNumbers), lotto.isMatchBonusNumber(winningLottoNumbers, bonusNumber)))
                .filter(rank -> rank != null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> INCREMENT_VALUE)));
    }

    public List<LottoNumbers> getLottos() {
        return lottos;
    }

}
