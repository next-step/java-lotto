package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    public static final int MATCH_COUNT_FIVE = 5;
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
            final int countOfMatch = winningLotto.match(lotto);
            final boolean bonusResult = canMatch(winningLotto, lotto, countOfMatch);
            final WinningPrize winningPrize = WinningPrize.from(countOfMatch, bonusResult);
            result.add(winningPrize);
        }
        return result;
    }

    private boolean canMatch(final WinningLotto winningLotto, final Lotto lotto, final int countOfMatch) {

        if (countOfMatch == MATCH_COUNT_FIVE) {
            return winningLotto.matchBonus(lotto);
        }
        return false;
    }

    public void add(final ManualLottos manualLottos) {

        final List<Lotto> lottos = manualLottos.getManualLottos()
                .getLottos();
        this.lottos.addAll(lottos);
    }
}
