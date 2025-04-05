package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;


public class LottoWallet {
    private final List<LottoNumbers> lottos = new ArrayList<>();

    public void addLotto(LottoNumbers lotto) {
        this.lottos.add(lotto);
    }

    public MatchResult countMatches(LottoNumbers winNumbers) {
        MatchResult matchResult = new MatchResult();
        for (LottoNumbers lotto : lottos) {
            matchResult.addMatchCount(lotto.countMatch(winNumbers));
        }
        return matchResult;
    }

    public int getCount() {
        return this.lottos.size();
    }

    public List<LottoNumbers> getLottos() {
        return this.lottos;
    }
}
