package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_RANGE = 0;
    private final List<Lotto> lottos;

    public Lottos(int gameCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(START_RANGE, gameCount).forEach(m -> lottos.add(new Lotto()) );
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> compareWinLotto(Lotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(lotto.matchCountLotto(winLotto.getLottoNumbers()));
            ranks.add(rank);
        }
        return ranks;
    }

    // 당첨 통계
}
