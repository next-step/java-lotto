package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private Lotto winningNumbers;

    public LottoStatistics(String winningNumbers, int bonusNumber) {
        this.winningNumbers = Lotto.manual(winningNumbers);
        this.winningNumbers.setBonusNumber(bonusNumber);
    }

    public LottoResult match(List<Lotto> lottos) {
        return new LottoResult(getJackpots(lottos));
    }

    private List<Rank> getJackpots(List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.getMatchJackpot(winningNumbers));
        }
        return ranks;
    }
}
