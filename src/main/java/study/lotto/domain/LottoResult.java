package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestWinningNumber;

/**
 * Lotto 결과에 대한 통계 클래스
 */
public class LottoResult {

    private final Lottos lottos;
    private final WinningLotto winningLotto;

    public LottoResult(final Lotto lotto, final Lottos lottos, final LottoNumber bonusNumber) {
        this(lottos, new WinningLotto(lotto, bonusNumber));
    }

    public LottoResult(Lottos lottos, WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
    }

    public long count(final LottoMatch lottoMatch) {
        return lottos.statics(lottoMatch, winningLotto);
    }

    public double winningRate() {
        return lottos.winningRate(winningLotto);
    }
}
