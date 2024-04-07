package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Price.LOTTO;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(Budget budget) {
        this(generateLottosBy(budget));
    }

    public Lottos(Lotto lotto) {
        this(List.of(lotto));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private static List<Lotto> generateLottosBy(Budget budget) {
        List<Lotto> lottos = new ArrayList<>();

        if (budget.isEnoughToPay(LOTTO)) {
            lottos.addAll(generateLottosBy(budget.spend(LOTTO)));
            lottos.add(new Lotto());
            return lottos;
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Statistics computeStatistic(WinLotto winLotto) {
        return new Statistics(checkStatisticNumberMatch(winLotto));
    }

    private List<Statistic> checkStatisticNumberMatch(WinLotto winLotto) {
        return lottos.stream()
                .map(lotto -> getStatistic(winLotto, lotto))
                .collect(Collectors.toList());
    }

    private static Statistic getStatistic(WinLotto winLotto, Lotto lotto) {
        return Statistic.valueOfMatchNumber(
                winLotto.getFeatNumberCount(lotto),
                winLotto.isContainBonus(lotto)
        );
    }

    public Lottos combine(Lottos lottos) {
        List<Lotto> newLottos = new ArrayList<>(this.lottos);
        List<Lotto> combineLottos = lottos.getLottos();
        newLottos.addAll(combineLottos);
        return new Lottos(newLottos);
    }
}
