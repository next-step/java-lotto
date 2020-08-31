package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Rank> collectRank(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> winningNumbers.getRank(lotto))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto -> lotto.toString())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public double calculateYield(int winnings) {
        return (double) winnings / (lottos.size() * LottoConfig.UNIT_PRICE);
    }

}
