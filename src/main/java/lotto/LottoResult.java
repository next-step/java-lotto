package lotto;

import lotto.domain.LottoDto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.math.BigDecimal;

import static java.util.stream.Collectors.toList;

public class LottoResult {

    public static Lottos rankOfMatch(final LottoDto lottoDto, final Rank rank) {

        if (rank == Rank.SECOND) {
            return new Lottos(
                    lottoDto.getLottos()
                            .stream()
                            .filter(lotto -> lotto.lottoOfRank(lottoDto.getLotto(), rank))
                            .filter(lotto -> lotto.eqBonus(lottoDto.getBonus()))
                            .collect(toList()));
        }

        return new Lottos(lottoDto.getLottos().stream().filter(lotto -> lotto.lottoOfRank(lottoDto.getLotto(), rank)).collect(toList()));
    }

    public static double calculatorRate(final LottoDto lottoDto, final int amount) {
        return calculatorLottoRate(amount, calculatorRewordAmount(lottoDto));
    }

    private static int calculatorRewordAmount(final LottoDto lottoDto) {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            sum += rankOfMatch(lottoDto, rank).getLottos().size() * rank.getWinningMoney();
        }
        return sum;
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled", "RedundantSuppression"})
    private static double calculatorLottoRate(final int lottoPurchaseAmount, final int rewordAmount) {
        return new BigDecimal(rewordAmount).divide(new BigDecimal(lottoPurchaseAmount)).doubleValue();
    }

}
