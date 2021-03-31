package step4;

import step3.domain.WinningLotto;

import java.util.*;

public class LottoGame {

    private List<Lotto> lottos;
    private Map<Rank, Integer> lottoResult = new TreeMap<>();

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void reset() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, 0);
        }
    }

    public Map<Rank, Integer> result(LottoWinner lottoWinner) {
        reset();
        for (Lotto lotto : lottos) {
            Rank matchedRank = lottoWinner.match(lotto);
            lottoResult.put(matchedRank, lottoResult.get(matchedRank) + 1);
        }

        return lottoResult;
    }

    public List<Lotto> allLotto() {
        return Collections.unmodifiableList(this.lottos);
    }
}
