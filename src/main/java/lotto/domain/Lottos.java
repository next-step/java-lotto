package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Integer> ... rawLottos) {
        List<Lotto> lottos = Arrays.stream(rawLottos)
                .map(Lotto::from)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public PrizeSummary getPrizeSummary(WinningCombo winningCombo) {
        Map<Rank, Integer> prizeSummary = initializePrizeSummary();
        countPrizes(winningCombo, prizeSummary);
        return new PrizeSummary(prizeSummary);
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
