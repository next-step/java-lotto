package lotto.domain;

import java.util.List;

public class LottoWinningEvaluator {
    private final LottoBundle lottoBundle;
    private final Lotto evaluationLotto;
    private final LottoNumber bonusLottoNumber;

    public LottoWinningEvaluator(final LottoBundle lottoBundle, final Lotto evaluationLotto, final LottoNumber bonusLottoNumber) {
        this.lottoBundle = lottoBundle;
        this.evaluationLotto = evaluationLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public LottoWinningResults evaluate() {
        final LottoRankGroup lottoRankGroup = new LottoRankGroup();

        for (final Lotto lotto : lottoBundle) {
            final int matchedCount = lotto.matchCount(evaluationLotto);
            final boolean isMatchedBonusNumber = lotto.contains(bonusLottoNumber);
            final LottoRank lottoRank = LottoRank.findLottoRankByMatchedNumber(matchedCount, isMatchedBonusNumber);
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
