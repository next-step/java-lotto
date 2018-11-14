package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private Lotto winningNumbers;
    private int bonusNumber;

    public LottoStatistics(String winningNumbers, int bonusNumber) {
        this.winningNumbers = Lotto.manual(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult match(List<Lotto> lottos) {
        return new LottoResult(getRanks(lottos));
    }

    private List<Rank> getRanks(List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(lotto.getMatchRank(winningNumbers, bonusNumber));
        }
        return ranks;
    }
}
