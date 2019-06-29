package lotto.view;

import lotto.exception.InvalidCountOfLottoException;
import lotto.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String MANUAL_PURCHASE_QUANTITY_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요.";
  private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
  private static final String NOT_A_NUMBER_INPUT_ERROR_MESSAGE = "숫자로 제대로 입력해주세요.";
  private static final String DELIMITER_FOR_WINNING_NUMBERS = ",( )?";

  public static Money askPurchaseAmount() {
    print(PURCHASE_AMOUNT_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      int paid = scanner.nextInt();
      return new Money(paid);
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public static Quantity askManualPurchaseQuantity(Money paidMoney) {
    print(MANUAL_PURCHASE_QUANTITY_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      int count = scanner.nextInt();
      if (count > paidMoney.getPurchaseableQuantity()) {
        throw new InvalidCountOfLottoException();
      }

      return new Quantity(count);
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public static List<Lotto> askLottoNumbersToBuyManually(Quantity quantity, Money paidMoney) {
    print(MANUAL_NUMBERS_MESSAGE);

    Scanner scanner = new Scanner(System.in);
    List<Lotto> manualLottos = new ArrayList<>();

    while(quantity.exists()) {
      try {
        String input = scanner.nextLine();
        List<LottoNumber> lottoNumbers = Stream.of(input.split(DELIMITER_FOR_WINNING_NUMBERS))
                .mapToInt(Integer::valueOf)
                .boxed()
                .sorted()
                .map(LottoNumber::new)
                .collect(toList());

        manualLottos.add(new Lotto(lottoNumbers));
        paidMoney.makePayment(quantity);
        quantity.reduce();
      } catch(InputMismatchException e) {
        throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
      }
    }

    return manualLottos;
  }

  public static Lotto askWinningNumbers() {
    print(WINNING_NUMBERS_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      List<LottoNumber> winningNumbers = Stream.of(input.split(DELIMITER_FOR_WINNING_NUMBERS))
              .mapToInt(Integer::valueOf)
              .boxed()
              .map(LottoNumber::new)
              .collect(toList());

      return LottoGenerator.generate(winningNumbers);
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public static LottoNumber askBonusNumber() {
    print(BONUS_NUMBER_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      return new LottoNumber(scanner.nextInt());
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  private static void print(String msg) {
    System.out.println(msg);
  }
}
