package lotto;

import static StringCalculator.Calculation.multiply;
import static util.Validator.validateArgument;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

public class LottoList {

  private static final String ERROR_MESSAGE_FOR_INVALID_AMOUNT = "Lotto를 생성할 숫자는 0보다 커야합니다.";
  private static final String LOTTO_DELIMITER = "\n";
  private final List<Lotto> lottoList = new ArrayList<>();

  private static final int LOTTO_PRICE = 1000;
  private static final int REVENUE_RATE_SCALE = 2;

  LottoList(int amount) {
    validateAmount(amount);
    for (int i = 0; i < amount; i++) {
      lottoList.add(new Lotto());
    }
  }

  LottoList(List<Lotto> lottoList) {
    this.lottoList.addAll(lottoList);
  }

  public int getMatchedLottoCount(int matchedCount, Lotto otherLotto) {
    return (int) lottoList.stream()
        .filter(lotto -> lotto.matches(matchedCount, otherLotto))
        .count();
  }

  public int getTotalLottoCount() {
    return lottoList.size();
  }

  public String toStringForPrinting() {
    StringJoiner joiner = new StringJoiner(LOTTO_DELIMITER);
    lottoList.forEach(lotto -> joiner.add(lotto.toStringForPrinting()));
    return joiner.toString();
  }

  public BigDecimal calculateRevenueWithWinningNumber(Lotto winningLotto) {
    AtomicInteger totalRevenue = new AtomicInteger();
    Arrays.stream(LottoPrize.values())
        .forEach(lottoPrize -> {
          int matchedLottoCount = lottoPrize.getMatchedLottoCount(winningLotto,this);
          lottoPrize.printingRevenue(matchedLottoCount);
          totalRevenue.addAndGet(lottoPrize.getRevenue(matchedLottoCount));
        });

    return BigDecimal.valueOf(totalRevenue.get())
        .divide(
            BigDecimal.valueOf(multiply(getTotalLottoCount(), LOTTO_PRICE)),
            REVENUE_RATE_SCALE,
            RoundingMode.HALF_UP
        );
  }

  private void validateAmount(int amount) {
    validateArgument(
        amount,
        (arg) -> amount > 0,
        ERROR_MESSAGE_FOR_INVALID_AMOUNT
    );
  }
}
