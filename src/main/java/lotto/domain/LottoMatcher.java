package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatcher {
    private LottoMatcher() {
    }

    public static Map<Rank, Integer> matchWithWinningLottoNumbers(final Lottos lottos, final Lotto winningLotto, int bonusBallNumber) {
        Map<Rank, Integer> rankMap = Rank.valuesExcludeNoRewards().stream()
                .collect(Collectors.toMap(rank -> rank, rank -> 0, (a, b) -> a, LinkedHashMap::new));
        for (Lotto lotto : lottos.value()) {
            int matchCount = lotto.countSameNumber(winningLotto);
            boolean matchBonus = lotto.contains(bonusBallNumber);
            rankMap.computeIfPresent(Rank.findRank(matchCount, matchBonus), (rank, count) -> count + 1);
        }

        return rankMap;
    }

    public static BigDecimal calculateTotalRewardsRatio(int purchasedMoney, Map<Rank, Integer> lottoResultRankMap) {
        BigDecimal totalRewards = lottoResultRankMap.entrySet().stream()
                .map(rank -> BigDecimal.valueOf(rank.getKey().getRewards() * rank.getValue()))
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return totalRewards.divide(BigDecimal.valueOf(purchasedMoney * 100.0), 2, RoundingMode.HALF_EVEN);
    }

}
