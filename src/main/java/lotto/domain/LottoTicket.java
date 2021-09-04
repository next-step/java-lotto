package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult matchWinning(Lotto lastWeekNumbers) {
        Map<LottoRank, Integer> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.askMatchCount(lastWeekNumbers);
            LottoRank lottoRank = LottoRank.findByMatchCount(matchCount);
            ranks.put(lottoRank, ranks.getOrDefault(lottoRank, 0) + 1);
        }
        return new LottoResult(ranks);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
