package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestWinningNumber;

/**
 * Lotto 결과에 대한 통계 클래스
 */
public class LottoResult {

    private final RequestWinningNumber winningNumber;
    private final LottoNumber bonusNumber;
    private final Lottos lottos;

    public LottoResult(final RequestWinningNumber winningNumber, final Lottos lottos, final LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    public long count(final LottoMatch lottoMatch) {
        return lottos.statics(lottoMatch, winningNumber, bonusNumber);
    }

    public double winningRate() {
        return lottos.winningRate(winningNumber, bonusNumber);
    }
}
