package lotto.domain;

import java.util.List;

public class LottoWinningEvaluator {
    private final LottoBundle lottoBundle;
    private final Lotto evaluationLotto;

    public LottoWinningEvaluator(final LottoBundle lottoBundle, final Lotto evaluationLotto) {
        this.lottoBundle = lottoBundle;
        this.evaluationLotto = evaluationLotto;
    }

    public LottoWinningResults evaluate() {
        final LottoRankGroup lottoRankGroup = new LottoRankGroup();

        for (final Lotto lotto : lottoBundle) {
            final int matchedCount = lotto.matchCount(evaluationLotto);
            final LottoRank lottoRank = LottoRank.findLottoRankByMatchedCount(matchedCount);
            lottoRankGroup.addLotto(lottoRank, lotto);
        }

        return new LottoWinningResults(
            List.of(
                createLottoWinningResult(lottoRankGroup, LottoRank.first()),
                createLottoWinningResult(lottoRankGroup, LottoRank.third()),
                createLottoWinningResult(lottoRankGroup, LottoRank.fourth()),
                createLottoWinningResult(lottoRankGroup, LottoRank.fifth())
            )
        );
    }

    private LottoWinningResult createLottoWinningResult(final LottoRankGroup lottoRankGroup, final LottoRank rank) {
        return new LottoWinningResult(
            rank, lottoRankGroup.getLottoBundleByRank(rank)
        );
    }
}
