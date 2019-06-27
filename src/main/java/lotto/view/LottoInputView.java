package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoInputView {

  private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨번호를 입력해 주세요.";
  private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
  private static final String NOT_A_NUMBER_INPUT_ERROR_MESSAGE = "숫자로 제대로 입력해주세요.";
  private static final String DELIMITER_FOR_WINNING_NUMBERS = ",( )?";

  public static int askPurchaseAmount() {
    print(PURCHASE_AMOUNT_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      int paid = scanner.nextInt();
      return paid;
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public static Lotto askWinningNumbers() {
    print(WINNING_NUMBERS_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      List<Integer> winningNumbers = Stream.of(input.split(DELIMITER_FOR_WINNING_NUMBERS))
              .mapToInt(Integer::valueOf)
              .boxed()
              .collect(toList());

      return LottoGenerator.generate(winningNumbers);
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  public static int askBonusNumber() {
    print(BONUS_NUMBER_MESSAGE);

    try {
      Scanner scanner = new Scanner(System.in);
      return scanner.nextInt();
    } catch(InputMismatchException e) {
      throw new IllegalArgumentException(NOT_A_NUMBER_INPUT_ERROR_MESSAGE);
    }
  }

  private static void print(String msg) {
    System.out.println(msg);
  }
}
