package lottogame.domain.lotto;

import lottogame.domain.strategy.LottoAutoStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new LottoAutoStrategy()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public WinningResult calculateWinningStatistics(WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = lottos.stream()
                .map(lotto -> Rank.from(winningLotto.countMatchingNumbers(lotto), winningLotto.isMatchingBonus(lotto)))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));

        return new WinningResult(rankCounts);
    }

    public static Lottos merge(Lottos first, Lottos second) {
        List<Lotto> mergedLottos = new ArrayList<>(first.getLottos());
        mergedLottos.addAll(second.getLottos());
        return new Lottos(mergedLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
