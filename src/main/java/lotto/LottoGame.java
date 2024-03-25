package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void add(List<Lotto> manualLottos) {
        this.lottos.addAll(manualLottos);
    }

    public RankMap getPrizeByRank(WiningLotto winningLotto) {
        List<MatchedCount> collect = lottos.stream()
                .map(winningLotto::countMatchedNumber)
                .filter(MatchedCount::isWin)
                .collect(Collectors.toList());
        return new RankMap(collect);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGame)) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottos, lottoGame.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
