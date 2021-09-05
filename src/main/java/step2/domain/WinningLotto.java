package step2.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public Match match(Lottos issueLottos) {
        final Match match = new Match();
        for (Lotto issueLotto : issueLottos.lottos) {
            int matchCount = issueLotto.match(this.lottoNumbers);
            match.add(matchCount);
        }
        return match;
    }
}
