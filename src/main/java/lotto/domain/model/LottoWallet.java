package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;


public class LottoWallet {
    private final List<LottoNumbers> lottos = new ArrayList<>();

    public void addLotto(LottoNumbers lotto) {
        this.lottos.add(lotto);
    }

    public MatchResult countMatches(LottoNumbers winNumbers, int bonusNumber) {
        MatchResult matchResult = new MatchResult(winNumbers, bonusNumber);
        for (LottoNumbers lotto : lottos) {
            matchResult.addRank(lotto);
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
