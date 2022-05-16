package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseList {

    private final List<Lotto> values;

    public PurchaseList(List<Lotto> lottos) {
        this.values = lottos;
    }

    public List<LottoRank> calculateRankEach(WinningLotto winningLotto) {
        return values.stream()
                .map(winningLotto::calculateRank)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.values.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
