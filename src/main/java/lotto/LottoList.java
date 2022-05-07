package lotto;

import static util.Validator.validateArgument;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoList {

  private static final String ERROR_MESSAGE_FOR_INVALID_AMOUNT = "Lotto를 생성할 숫자는 0보다 커야합니다.";
  private static final int LOTTO_PRICE = 1000;
  private static final int REVENUE_RATE_SCALE = 2;

  private final List<Lotto> lottoList = new ArrayList<>();


  LottoList(int lottoAmount) {
    validateAmount(lottoAmount);
    for (int i = 0; i < lottoAmount; i++) {
      lottoList.add(Lotto.create());
    }
  }

  LottoList(PaymentAmount paymentAmount) {
    this(paymentAmount.purchaseLotto(LOTTO_PRICE));
  }

  LottoList(List<Lotto> lottoList) {
    this.lottoList.addAll(lottoList);
  }

  public Result drawing(WinningLotto winningLotto) {
    Result result = new Result();

    for (Lotto lotto : lottoList) {
      LottoPrize lottoPrize = LottoPrize.valueOf(
          winningLotto.matchedCount(lotto),
          winningLotto.matchedBonus(lotto)
      );
      result.add(lottoPrize);
    }

    return result;
  }

  public int getTotalLottoCount() {
    return lottoList.size();
  }

  public int getTotalPurchaseAmount() {
    return getTotalLottoCount() * LOTTO_PRICE;
  }

  public List<Lotto> getListOfLotto() {
    return lottoList.stream().collect(Collectors.toUnmodifiableList());
  }

  public BigDecimal getRevenueRate(int totalRevenue) {
    return BigDecimal.valueOf(totalRevenue)
        .divide(
            BigDecimal.valueOf(getTotalPurchaseAmount()),
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
