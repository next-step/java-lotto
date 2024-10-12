package lotto.domain;

import java.util.List;

public class LottoWinningEvaluator {
    private final LottoBundle lottoBundle;
    private final LastWeekWinningLotto lastWeekWinningLotto;

    public LottoWinningEvaluator(final LottoBundle lottoBundle, final LastWeekWinningLotto lastWeekWinningLotto) {
        this.lottoBundle = lottoBundle;
        this.lastWeekWinningLotto = lastWeekWinningLotto;
    }

    public LottoWinningResults evaluate() {
        final LottoRankGroup lottoRankGroup = new LottoRankGroup();

        for (final Lotto lotto : lottoBundle) {
            final LottoRank lottoRank = lastWeekWinningLotto.calculateLottoRank(lotto);
            lottoRankGroup.addLotto(lottoRank, lotto);
        }

        return new LottoWinningResults(
            List.of(
                createLottoWinningResult(lottoRankGroup, LottoRank.FIRST),
                createLottoWinningResult(lottoRankGroup, LottoRank.SECOND),
                createLottoWinningResult(lottoRankGroup, LottoRank.THIRD),
                createLottoWinningResult(lottoRankGroup, LottoRank.FOURTH),
                createLottoWinningResult(lottoRankGroup, LottoRank.FIFTH)
            )
        );
    }

    private LottoWinningResult createLottoWinningResult(final LottoRankGroup lottoRankGroup, final LottoRank rank) {
        return new LottoWinningResult(
            rank, lottoRankGroup.getLottoBundleByRank(rank)
        );
    }
}
