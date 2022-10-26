package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatisticalService {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public LottoStatisticalService(Lotto winningLotto, LottoNumber bonusNumber) {
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

    public float calculateYield(int paymentAmount, Long winningAmount) {
        return (float) winningAmount / paymentAmount;
    }
}
