package lottogame.domain;

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

    public Map<Rank, Integer> calculateWinningStatistics(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> Rank.from(lotto.countMatchingNumbers(winningLotto)))
                .collect(Collectors.groupingBy(rank -> rank, Collectors.summingInt(rank -> 1)));
    }

    public double calculateTotalPrizeAmount(Lotto winningLotto) {
        return lottos.stream()
                .mapToDouble(lotto -> Rank.from(lotto.countMatchingNumbers(winningLotto)).getAmount())
                .sum();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
