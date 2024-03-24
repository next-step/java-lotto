package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame(Money budget, Money lottoPrice) {
        this(buyLottos(budget, lottoPrice));
    }

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static List<Lotto> buyLottos(Money budget, Money lottoPrice) {
        return Stream.generate(Lotto::new)
                .limit(budget.purchase(lottoPrice))
                .collect(Collectors.toList());
    }

    public RankMap getPrizeByRank(Lotto winningLotto) {
        List<MatchedCount> collect = lottos.stream()
                .map(lotto -> lotto.countMatchedNumber(winningLotto))
                .filter(MatchedCount::isWin)
                .collect(Collectors.toList());
        return new RankMap(collect);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
