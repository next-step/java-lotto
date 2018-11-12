package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(final Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static List<Lotto> filter(final LottoNumber lottoNumber, final List<Lotto> lottos, final int matchNumber) {
        return lottos.stream().filter(lotto -> lotto.isMatchNumber(lottoNumber, matchNumber)).collect(toList());
    }

    public static double getRate(final LottoNumber lottoNumber, final List<Lotto> lottos, final int lottoPurchaseAmount) {
        return calculatorLottoRate(lottoPurchaseAmount, calculatorRewordAmount(lottoNumber, lottos));
    }

    private static int calculatorRewordAmount(LottoNumber lottoNumber, List<Lotto> lottos) {
        int sum = 0;
        for (Reward reward : Reward.NUMBERS) {
            sum += Lottos.filter(lottoNumber, lottos, reward.getMatchNumber()).size() * reward.getPrice();
        }
        return sum;
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled", "RedundantSuppression"})
    private static double calculatorLottoRate(int lottoPurchaseAmount, int rewordAmount) {
        return new BigDecimal(rewordAmount).divide(new BigDecimal(lottoPurchaseAmount)).doubleValue();
    }

}
