package lotto;

import static StringCalculator.Calculation.multiply;
import static util.Validator.validateArgument;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import util.InputView;
import util.OutputView;

public class LottoController {

  private static final String MESSAGE_FOR_INSERT_PAYMENT_AMOUNT = "구입 금액을 입력해주세요.";
  private static final String MESSAGE_FOR_INVALID_PAYMENT_AMOUNT = "구입 금액은 최소 %s 이상이어야 합니다.";
  private static final String MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT = "%s개를 구매했습니다.";
  private static final String MESSAGE_FOR_INSERT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String MESSAGE_FOR_PRINTING_RESULT = "총 수익률은 %s 입니다.";
  private static final String NUMBERS_DELIMITER = ", ";

  private static final int REVENUE_RATE_SCALE = 2;
  private static final int LOTTO_PRICE = 1000;

  private LottoList lottoList;
  private Lotto winningLotto;


  public LottoController purchaseByInput() {
    int paymentAmount = InputView.scanInt(MESSAGE_FOR_INSERT_PAYMENT_AMOUNT);
    return purchase(paymentAmount);
  }

  private LottoController purchase(int paymentAmount) {
    validatePaymentAmount(paymentAmount);
    int purchaseAmount = getLottoAmount(paymentAmount);

    this.lottoList = new LottoList(purchaseAmount);
    OutputView.print(buildPurchaseAmountMessage(purchaseAmount));
    OutputView.print(lottoList.toString());
    return this;
  }

  public LottoController insertWinningNumber() {
    return setWinningNumber(InputView.scanString(MESSAGE_FOR_INSERT_WINNING_NUMBERS));
  }

  private LottoController setWinningNumber(String winningNumber) {
    this.winningLotto = new Lotto(
        Stream.of(winningNumber.split(NUMBERS_DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toSet())
    );
    return this;
  }

  public void printRevenue() {
    BigDecimal revenueRate = calculateRevenueWithWinningNumber(winningLotto);
    OutputView.print(String.format(MESSAGE_FOR_PRINTING_RESULT, revenueRate));
  }

  private BigDecimal calculateRevenueWithWinningNumber(Lotto winningLotto) {
    AtomicInteger totalRevenue = new AtomicInteger();
    Arrays.stream(LottoPrize.values())
        .forEach(lottoPrize -> {
          int matchedLottoCount = lottoPrize.getMatchedLottoCount(winningLotto, lottoList);
          lottoPrize.printingRevenue(matchedLottoCount);
          totalRevenue.addAndGet(lottoPrize.getRevenue(matchedLottoCount));
        });

    return BigDecimal.valueOf(totalRevenue.get())
        .divide(
            BigDecimal.valueOf(multiply(lottoList.getTotalLottoCount(), LOTTO_PRICE)),
            REVENUE_RATE_SCALE,
            RoundingMode.HALF_UP
        );
  }

  private int getLottoAmount(int money) {
    return money / LOTTO_PRICE;
  }

  private String buildPurchaseAmountMessage(int purchaseAmount) {
    return String.format(MESSAGE_FOR_PRINTING_PURCHASE_AMOUNT, purchaseAmount);
  }

  private String buildInvalidPaymentAmountMessage(int purchaseAmount) {
    return String.format(MESSAGE_FOR_INVALID_PAYMENT_AMOUNT, LOTTO_PRICE);
  }

  private void validatePaymentAmount(int paymentAmount) {
    validateArgument(
        paymentAmount,
        (arg) -> paymentAmount >= LOTTO_PRICE,
        buildInvalidPaymentAmountMessage(paymentAmount)
    );
  }

  public static LottoController init() {
    return new LottoController();
  }
}
