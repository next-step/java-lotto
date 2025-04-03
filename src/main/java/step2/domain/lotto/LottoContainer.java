package step2.domain.lotto;

import step2.domain.rank.RankType;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(int lottoCount, LottoGenerator lottoGenerator) {
        if (isInvalid(lottoCount)) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }

        this.lottos = initializeLottos(lottoCount, lottoGenerator);
    }

    public LottoContainer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public List<RankType> checkWinningResults(WinningLotto winningLotto) {
        List<RankType> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            RankType rank = winningLotto.determineRank(lotto);
            ranks.add(rank);
        }
        return ranks;
    }

    private boolean isInvalid(int lottoCount) {
        return lottoCount <= 0;
    }

    private List<Lotto> initializeLottos(int lottoCount, LottoGenerator lottoGenerator) {
        final List<Lotto> lottos;
        lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = Lotto.auto(lottoGenerator);
            lottos.add(lotto);
        }
        return lottos;
    }
}
