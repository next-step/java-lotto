package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    private final int count;
    private final List<Lotto> autoLottos;

    public BoughtLottos(final List<Lotto> lottos) {
        this.count = lottos.size();
        this.autoLottos = lottos;
    }

    public WinningStatistics winningResults(final WinningLotto winningLotto) {
        return new WinningStatistics(autoLottos.stream()
                .map(winningLotto::isMatch)
                .collect(Collectors.toList()));
    }

    public int getCount() {
        return this.count;
    }

    public List<Lotto> getAutoLottos() {
        return this.autoLottos;
    }
}
