package step2.domain.lotto;

import step2.domain.statistics.WinningStatistics;
import step2.vo.Rank;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        super(lottoNumbers);

        if (this.lottoNumbers.contained(bonusNumber)) {
            throw new RuntimeException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public WinningStatistics match(Lottos issueLottos) {
        final WinningStatistics winningStatistics = new WinningStatistics();
        for (Lotto issueLotto : issueLottos.lottos) {
            Rank matchRank = issueLotto.match(this.lottoNumbers, bonusNumber);
            winningStatistics.add(matchRank);
        }
        return winningStatistics;
    }
}
