package lotto.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoRank.*;

public class LottoCheck {

    public static int getWinningLottoCount(final List<Lotto> lottos, final Lotto winningLotto, final LottoRank rank) {
        int rankCount = 0;
        List<Integer> containWinningNumberCounts = getContainCountsSame(lottos, winningLotto.getNumbers());
        for(Integer containCount : containWinningNumberCounts) {
            rankCount = addRankCount(rankCount, containCount, rank);
        }
        return rankCount;
    }

    private static List<Integer> getContainCountsSame(final List<Lotto> lottos, final List<Integer> winningNumbers) {
        List<Integer> counts = new ArrayList<>();
        for(Lotto lotto : lottos) {
            counts.add(lotto.getContainCount(winningNumbers));
        }
        return counts;
    }

    private static int addRankCount(final int currentRankCount, final Integer containCount, final LottoRank rank) {
        int result = currentRankCount;
        if(containCount.equals(rank.getContainCountsSameWinningNumber())) {
            result++;
        }
        return result;
    }

    public static BigDecimal getWinningAmount(final List<Lotto> lottos, final Lotto winningLotto) {
        return getWinningAmount(lottos, winningLotto, RANK1)
                .add(getWinningAmount(lottos, winningLotto, RANK2))
                .add(getWinningAmount(lottos, winningLotto, RANK3))
                .add(getWinningAmount(lottos, winningLotto, RANK4));
    }

    private static BigDecimal getWinningAmount(final List<Lotto> lottos,
                                               final Lotto winningLotto,
                                               final LottoRank lottoRank) {
        return BigDecimal.valueOf(getWinningLottoCount(lottos, winningLotto, lottoRank))
                .multiply(lottoRank.getWinningAmount());
    }
}
