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

    public static List<Lotto> filter(final List<Lotto> lottos, final List<Integer> numbers, final int matchNumber) {
        return lottos.stream().filter(lotto -> lotto.isMatchNumber(numbers, matchNumber)).collect(toList());
    }

    public static double getRate(final List<Lotto> lottos, final List<Integer> numbers, final int amount) {
        return calculatorLottoRate(amount, calculatorRewordAmount(lottos, numbers));
    }

    private static int calculatorRewordAmount(final List<Lotto> lottos, final List<Integer> numbers) {
        int sum = 0;
        for (Reward reward : Reward.NUMBERS) {
            sum += Lottos.filter(lottos, numbers, reward.getMatchNumber()).size() * reward.getPrice();
        }
        return sum;
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled", "RedundantSuppression"})
    private static double calculatorLottoRate(final int lottoPurchaseAmount, final int rewordAmount) {
        return new BigDecimal(rewordAmount).divide(new BigDecimal(lottoPurchaseAmount)).doubleValue();
    }

}
