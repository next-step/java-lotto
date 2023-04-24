package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int ZERO = 0;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos initLottos(Money amount) {
        List<Lotto> lottos = new ArrayList<>();
        int bound = amount.getLottoQuantity();
        for (int i = ZERO; i < bound; i++) {
            Lotto lotto = Lotto.initLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public int getLottoQuantity() {
        return lottos.size();
    }

    public Winners findStatistics(Lotto winningLotto) {
        Winners winners = new Winners();
        lottos.stream()
                .mapToInt(lotto -> lotto.findMatchingBall(winningLotto))
                .forEach(winners::addWinner);

        return winners;
    }

    @Override
    public String toString() {
        return "" + lottos;
    }
}
