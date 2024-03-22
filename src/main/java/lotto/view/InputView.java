package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
  private static final String IS_NOT_NUMBER_FORMAT = "숫자 형식이 올바르지 않습니다. input: %s, errorMessage: %s";
  private static final String UNEXPECTED_ERROR = "예기치 못한 에러가 발생했습니다. input: %s, errorMessage: %s";
  private static final String NEGATIVE_NUMBER_OR_ZERO_IS_NOT_ALLOWED = "입력 값이 잘못되었습니다. 0이나 음수는 허용되지 않습니다. input: %s";

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String WINNING_NUMBER_SEPARATOR = ", ";

  public InputView() {
  }

  public int receivePurchaseAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return validateInputNumber(toInt(SCANNER.nextLine()));
  }

  public Set<Integer> receiveWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return Arrays.stream(SCANNER.nextLine().split(WINNING_NUMBER_SEPARATOR))
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
  }

  public int receiveBonusBall() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return validateInputNumber(toInt(SCANNER.nextLine()));
  }

  private static int toInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      throw new NumberFormatException(String.format(IS_NOT_NUMBER_FORMAT, input, nfe.getMessage()));
    } catch (Exception e) {
      throw new RuntimeException(String.format(UNEXPECTED_ERROR, input, e.getMessage()), e);
    }
  }

  private static int validateInputNumber(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_OR_ZERO_IS_NOT_ALLOWED, number));
    }
    return number;
  }
}
