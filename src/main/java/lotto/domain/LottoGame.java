package lotto.domain;

import java.util.Optional;

public class LottoGame {

    public static LottoResult match(Lotto winningLotto, LottoNumber bonusBall, Lottos lottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.countOfMatch(lotto);
            LottoRanking lottoRanking = LottoRanking.valueOf(countOfMatch, () -> lotto.contain(bonusBall));
            Optional.ofNullable(lottoRanking).ifPresent(lottoResult::addRanking);
        }
        return lottoResult;
    }

}
