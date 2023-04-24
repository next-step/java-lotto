package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int ZERO = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos initLottos(Money amount) {
        List<Lotto> lottos;
        int bound = amount.getLottoQuantity();
        lottos = IntStream.range(ZERO, bound)
                .mapToObj(i -> Lotto.initLotto())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public Winners findStatistics(Lotto winningLotto, LottoNumber bonusNumber) {
        Winners winners = new Winners();
        lottos.forEach(lotto -> {
            winners.addWinner(lotto.findMatchingBall(winningLotto), lotto.hasBonusNumber(bonusNumber));
        });

        return winners;
    }

    @Override
    public String toString() {
        return "" + lottos;
    }
}
