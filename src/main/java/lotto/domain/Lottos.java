package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos mergeLottos(Lottos autoLottos) {
        List<Lotto> manualLottos = this.lottos;

        return autoLottos.mergeWith(manualLottos);
    }

    private Lottos mergeWith(List<Lotto> manualLottos) {
        List<Lotto> autoLottos = this.lottos;

        manualLottos.addAll(autoLottos);
        return new Lottos(manualLottos);
    }

    public PrizeSummary getPrizeSummary(WinningCombo winningCombo) {
        Map<Rank, Integer> prizeSummary = initializePrizeSummary();
        countPrizes(winningCombo, prizeSummary);
        return new PrizeSummary(prizeSummary);
    }

    private Map<Rank, Integer> initializePrizeSummary() {
        Map<Rank, Integer> prizeSummary = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            prizeSummary.put(rank, 0);
        }
        return prizeSummary;
    }

    private void countPrizes(WinningCombo winningCombo, Map<Rank, Integer> prizeSummary) {
        for (Lotto lotto : lottos) {
            Rank rank = winningCombo.determinePrize(lotto);
            prizeSummary.put(rank, prizeSummary.get(rank) + 1);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
