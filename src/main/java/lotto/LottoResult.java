package lotto;

import lotto.domain.LottoDto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Rank.values;

public class LottoResult {

    public static Lottos rankOfMatch(final LottoDto lottoDto, final Rank rank) {
        return new Lottos(
                lottoDto.getLottos()
                        .stream()
                        .filter(lotto -> lotto.lottoOfRank(lottoDto.getLotto(), rank, lottoDto.getBonus()))
                        .collect(toList()));
    }

    public static double calculatorRate(final LottoDto lottoDto, final int amount) {
        return calculatorLottoRate(amount, calculatorRewordAmount(lottoDto));
    }

    public static Map<Rank, Lottos> calculateLottoResult(final LottoDto lottoDto) {
        final Map<Rank, Lottos> result = new HashMap<>();
        for (Rank rank : values()) {
            if (rankMissIsContinue(rank)) continue;
            result.put(rank, rankOfMatch(lottoDto, rank));
        }
        return result;
    }

    private static boolean rankMissIsContinue(final Rank rank) {
        return rank.equals(Rank.MISS);
    }

    private static int calculatorRewordAmount(final LottoDto lottoDto) {
        int sum = 0;
        for (Rank rank : values()) {
            sum += multiplicationRankOfMatchSizeWithWinningMoney(lottoDto, rank);
        }
        return sum;
    }

    private static int multiplicationRankOfMatchSizeWithWinningMoney(final LottoDto lottoDto, final Rank rank) {
        return Lottos.rankOfMatchSize(rankOfMatch(lottoDto, rank)) * rank.getWinningMoney();
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled", "RedundantSuppression"})
    private static double calculatorLottoRate(final int lottoPurchaseAmount, final int rewordAmount) {
        return new BigDecimal(rewordAmount).divide(new BigDecimal(lottoPurchaseAmount)).doubleValue();
    }

}
