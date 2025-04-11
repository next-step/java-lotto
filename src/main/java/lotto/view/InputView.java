package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  public static final String READ_PRICE_QUESTION = "구입금액을 입력해 주세요.";
  public static final String READ_PREVIOUS_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
  public static final String READ_BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요.";
  public static final String READ_MANUAL_LOTTO_COUNT_QUESTION = "수동으로 구매할 로또 수를 입력해 주세요.";
  public static final String READ_MANUAL_LOTTO_NUMBERS_QUESTION = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String DELIMITER = ",";
  private final Scanner scanner;

  public InputView() {
    scanner = new Scanner(System.in);
  }

  public int readPrice() {
    System.out.println(READ_PRICE_QUESTION);
    int price = scanner.nextInt();
    scanner.nextLine();
    return price;
  }

  public int readManualLottoCount() {
    System.out.println(READ_MANUAL_LOTTO_COUNT_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  public List<List<Integer>> readManualLottoNumbers(int count) {
    if (count == 0) {
      return new ArrayList<>();
    }
    System.out.println(READ_MANUAL_LOTTO_NUMBERS_QUESTION);
    List<List<Integer>> manualLottoNumbers = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      manualLottoNumbers.add(parseNumbers(scanner.nextLine()));
    }
    return manualLottoNumbers;
  }

  public List<Integer> readWinningNumbers() {
    System.out.println(READ_PREVIOUS_NUMBER_QUESTION);
    return parseNumbers(scanner.nextLine());
  }

  public int readBonusBall() {
    System.out.println(READ_BONUS_BALL_QUESTION);
    return Integer.parseInt(scanner.nextLine());
  }

  private List<Integer> parseNumbers(String input) {
    return Arrays.stream(input.split(DELIMITER))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
