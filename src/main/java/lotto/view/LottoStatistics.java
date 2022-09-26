package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoStatistics {
    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private Lottos lottos;
    private Lotto winLotto;


    public LottoStatistics(Lottos lottos, Lotto winLotto) {
        this.lottos = lottos;
        this.winLotto = winLotto;
    }

    public double benefit() {
        return 0;
    }
}
