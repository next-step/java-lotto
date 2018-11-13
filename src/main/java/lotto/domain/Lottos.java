package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public void add(final Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static List<Lotto> findWinningNumbers(final WinningNumber winningNumber, final int matchNumber) {
        return winningNumber.filter(matchNumber);
    }

    public static double getRate(final WinningNumber winningNumber, final int amount) {
        return calculatorLottoRate(amount, calculatorRewordAmount(winningNumber));
    }

    private static int calculatorRewordAmount(final WinningNumber winningNumber) {
        int sum = 0;
        for (Reward reward : Reward.NUMBERS) {
            sum += Lottos.findWinningNumbers(new WinningNumber(winningNumber.getLottos(), winningNumber.getNumbers()), reward.getMatchNumber()).size() * reward.getPrice();
        }
        return sum;
    }

    @SuppressWarnings({"IntegerDivisionInFloatingPointContext", "BigDecimalMethodWithoutRoundingCalled", "RedundantSuppression"})
    private static double calculatorLottoRate(final int lottoPurchaseAmount, final int rewordAmount) {
        return new BigDecimal(rewordAmount).divide(new BigDecimal(lottoPurchaseAmount)).doubleValue();
    }

}
