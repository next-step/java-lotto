package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoRank.*;

public class LottoCheck {

    private LottoCheck() {}

    public static int getWinningLottoCount(final List<Lotto> lottos,
                                           final WinningLotto winningLotto,
                                           final LottoRank rank) {
        List<LottoRank> lottoRanks = getLottoRankEachLotto(lottos, winningLotto);
        return (int) lottoRanks.stream().filter(lottoRank -> lottoRank == rank).count();
    }

    private static List<LottoRank> getLottoRankEachLotto(final List<Lotto> lottos,
                                                          final WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for(Lotto lotto : lottos) {
            LottoRank lottoRank = LottoRank.getRank(winningLotto.getContainCount(lotto),
                    winningLotto.inContainBonus(lotto));
            lottoRanks.add(lottoRank);
        }
        return lottoRanks;
    }

    public static BigDecimal getTotalWinningAmount(final List<Lotto> lottos, final WinningLotto winningLotto) {
        return getTotalWinningAmount(lottos, winningLotto, RANK1)
                .add(getTotalWinningAmount(lottos, winningLotto, RANK2))
                .add(getTotalWinningAmount(lottos, winningLotto, RANK3))
                .add(getTotalWinningAmount(lottos, winningLotto, RANK4))
                .add(getTotalWinningAmount(lottos, winningLotto, RANK5));
    }

    private static BigDecimal getTotalWinningAmount(final List<Lotto> lottos,
                                                    final WinningLotto winningLotto,
                                                    final LottoRank lottoRank) {
        return BigDecimal.valueOf(getWinningLottoCount(lottos, winningLotto, lottoRank))
                .multiply(lottoRank.getWinningAmount());
    }
}
