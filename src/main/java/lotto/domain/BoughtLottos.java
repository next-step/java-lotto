package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BoughtLottos {

    public static final BoughtLottos EMPTY = new BoughtLottos(List.of());
    private final int count;
    private final List<Lotto> lottos;

    public BoughtLottos(final List<Lotto> lottos) {
        this.count = lottos.size();
        this.lottos = lottos;
    }

    public WinningStatistics winningResults(final WinningLotto winningLotto) {
        return new WinningStatistics(lottos.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList()));
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int getCount() {
        return this.count;
    }

    public List<LottoNumbers> getLottosNumbers() {
        return this.lottos.stream()
                .map(l -> new LottoNumbers(l.getBallValues()))
                .collect(Collectors.toList());
    }
}
