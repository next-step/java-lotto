package step2.domain.lotto;

import step2.domain.statistics.Match;
import step2.domain.statistics.Profit;
import step2.domain.statistics.Statistics;
import step2.domain.statistics.Rank;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);

        if (this.lottoNumbers.contained(bonusNumber)) {
            throw new RuntimeException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public Statistics match(Lottos issueLottos) {
        final Profit profit = new Profit();
        final Match match = new Match();
        for (Lotto issueLotto : issueLottos.lottos) {
            Rank matchRank = issueLotto.matchedRank(this.lottoNumbers, bonusNumber);
            match.add(matchRank);
            profit.add(matchRank);
        }
        return new Statistics(profit, match);
    }
}
