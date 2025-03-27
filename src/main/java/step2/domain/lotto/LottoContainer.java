package step2.domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(int lottoCount, LottoFactory lottoFactory) {
        if (isInvalid(lottoCount)) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }

        this.lottos = initializeLottos(lottoCount, lottoFactory);
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

    private List<Lotto> initializeLottos(int lottoCount, LottoFactory lottoFactory) {
        final List<Lotto> lottos;
        lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = lottoFactory.createLotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }
}
