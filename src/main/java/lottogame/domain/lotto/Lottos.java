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

    public Map<Rank, Integer> calculateWinningStatistics(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> Rank.from(lotto.countMatchingNumbers(winningLotto.getWinningLotto()), lotto.isMatchingBonus(winningLotto.getBonusNumber())))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));
    }

    public double calculateTotalPrizeAmount(WinningLotto winningLotto) {
        return lottos.stream()
                .mapToDouble(lotto -> Rank.from(lotto.countMatchingNumbers(winningLotto.getWinningLotto()), lotto.isMatchingBonus(winningLotto.getBonusNumber())).getPrizeMoney())
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
