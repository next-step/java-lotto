package domain.lotto;

import domain.LottoGameResult;

import java.util.ArrayList;
import java.util.List;

public class LottoContainer {
    private final List<Lotto> lottos;

    public LottoContainer(int lottoCount) {
        if (lottoCount <= 0) {
            throw new IllegalArgumentException("로또 개수는 1개 이상이어야 합니다.");
        }

        lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        }
    }

    public int size() {
        return lottos.size();
    }

    public LottoGameResult checkWinningResults(WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.determineRank(winningLotto);
            ranks.add(rank);
        }
        return new LottoGameResult(ranks);
    }
}
