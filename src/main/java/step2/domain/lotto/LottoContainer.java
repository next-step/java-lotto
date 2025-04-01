package step2.domain.lotto;

import step2.domain.rank.Rank;
import views.LottoContainerFormatter;
import views.LottoFormatter;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(int lottoCount, LottoRule lottoRule) {
        if (isInvalid(lottoCount)) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }

        this.lottos = initializeLottos(lottoCount, lottoRule);
    }

    public LottoContainer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Rank> checkWinningResults(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.determineRank(winningLotto);
            ranks.add(rank);
        }
        return ranks;
    }

    private boolean isInvalid(int lottoCount) {
        return lottoCount <= 0;
    }

    private List<Lotto> initializeLottos(int lottoCount, LottoRule lottoRule) {
        final List<Lotto> lottos;
        lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoRule);
            lottos.add(lotto);
        }
        return lottos;
    }

    public LottoContainerFormatter generateFormatter() {
        List<LottoFormatter> lottoFormatters = new ArrayList<>();
        for (Lotto lotto: lottos) {
            lottoFormatters.add(lotto.generateFormatter());
        }
        return new LottoContainerFormatter(lottoFormatters);
    }
}
