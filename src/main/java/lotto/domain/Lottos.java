package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {

        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {

        return Collections.unmodifiableList(this.lottos);
    }

    public List<WinningPrize> match(final WinningLotto winningLotto) {

        List<WinningPrize> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            final WinningPrize winningPrize = WinningPrize.of(winningLotto, lotto);
            result.add(winningPrize);
        }
        return result;
    }

    public void add(final ManualLottos manualLottos) {

        final List<Lotto> lottos = manualLottos.getManualLottos()
                .getLottos();
        this.lottos.addAll(lottos);
    }
}
