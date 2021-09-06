package step2.domain.lotto;

import step2.domain.statistics.WinningStatistics;
import step2.vo.Rank;

import java.util.List;

public class WinningLotto extends Lotto {
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumberValue) {
        super(lottoNumbers);

        final LottoNumber bonusNumber = new LottoNumber(bonusNumberValue);
        if (this.lottoNumbers.isContains(bonusNumber)) {
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
