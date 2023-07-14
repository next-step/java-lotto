package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    private final int autoCount;
    private final List<Lotto> autoLottos;

    public BoughtLottos(final List<Lotto> lottos) {
        this.autoCount = lottos.size();
        this.autoLottos = lottos;
    }

    public WinningStatistics winningResults(final WinningLotto winningLotto) {
        return new WinningStatistics(autoLottos.stream()
                .map(winningLotto::isMatch)
                .collect(Collectors.toList()));
    }

    public int getAutoCount() {
        return this.autoCount;
    }

    public List<Lotto> getAutoLottos() {
        return this.autoLottos;
    }
}
