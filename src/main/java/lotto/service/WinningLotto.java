package lotto.service;

import lotto.domain.enums.MatchNumberAndPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<MatchNumberAndPrize, Integer> giveStatistics(List<Lotto> purchasedLotto) {
        Map<MatchNumberAndPrize, Integer> result = initStatistics();
        for (Lotto lotto : purchasedLotto) {
            int matchNumber = lotto.containCount(winningLotto).intValue();
            boolean contain = lotto.contain(bonusNumber);
            MatchNumberAndPrize matchNumberAndPrize = MatchNumberAndPrize.valueOfMatchNumber(matchNumber, contain);
            result.put(matchNumberAndPrize, result.get(matchNumberAndPrize) + 1);
        }
        return result;
    }

    private Map<MatchNumberAndPrize, Integer> initStatistics() {
        Map<MatchNumberAndPrize, Integer> result = new HashMap<>();
        for (MatchNumberAndPrize matchNumberAndPrize : MatchNumberAndPrize.values()) {
            result.put(matchNumberAndPrize, 0);
        }
        return result;
    }
}
