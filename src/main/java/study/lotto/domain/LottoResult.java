package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.service.Lottos;

/**
 * Lotto 결과에 대한 통계 클래스
 */
public class LottoResult {

    private final Lottos resultLotto;
    private final WinningLotto winningLotto;

    protected LottoResult(final Lottos lotto) {
        this(lotto, null);
    }

    protected LottoResult(final Lottos resultLotto, final WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        this.resultLotto = resultLotto;
    }

    public static LottoResult of(final Lottos lotto) {
        return new LottoResult(lotto);
    }

    public static LottoResult of(final Lottos lotto, final WinningLotto winningLotto) {
        return new LottoResult(lotto, winningLotto);
    }

    public long count(final LottoMatch lottoMatch) {
        return resultLotto.matchStatics(lottoMatch, winningLotto);
    }

    public double winningRate() {
        return resultLotto.winningRate(winningLotto);
    }
}
