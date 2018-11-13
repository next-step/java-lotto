package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private Lotto winningNumbers;

    public LottoStatistics(String values) {
        winningNumbers = Lotto.manual(values);
    }

    public LottoResult match(List<Lotto> lottos) {
        return new LottoResult(getJackpots(lottos));
    }

    private List<Jackpot> getJackpots(List<Lotto> lottos) {
        List<Jackpot> jackpots = new ArrayList<>();
        for (Lotto lotto : lottos) {
            jackpots.add(lotto.getMatchJackpot(winningNumbers));
        }
        return jackpots;
    }
}
