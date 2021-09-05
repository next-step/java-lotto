package step2.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningStatistics match(Lottos issueLottos) {
        final WinningStatistics winningStatistics = new WinningStatistics();
        for (Lotto issueLotto : issueLottos.lottos) {
            int matchCount = issueLotto.match(this.lottoNumbers);
            winningStatistics.add(matchCount);
        }
        return winningStatistics;
    }
}
