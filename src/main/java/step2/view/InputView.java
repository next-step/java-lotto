package step2.view;

import step2.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String BUYING_AMOUNT_STR = "구입 금액을 입력해 주세요";
  private static final String WINNING_NUMBER_STR = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String BONUS_NUMBER_STR = "보너스 볼을 입력해 주세요.";
  private static final String MANUAL_LOTTO_COUNT_STR = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String MANUAL_LOTTO_NUMBER_STR = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String EMPTY_VALUE_ERROR_MESSAGE = "입력값이 비었습니다.";


  public static int getLottoPrice() {
    System.out.println(BUYING_AMOUNT_STR);
    String input = scanner.nextLine();
    emptyOrNullCheck(input);
    return Integer.parseInt(input);
  }

  public static String getWinningNumbers() {
    System.out.println(WINNING_NUMBER_STR);
    String input = scanner.nextLine();
    emptyOrNullCheck(input);
    return input;
  }

  public static String getBonusNumber() {
    System.out.println(BONUS_NUMBER_STR);
    String input = scanner.nextLine();
    emptyOrNullCheck(input);
    return input;
  }

  public static int getManualLottoCount() {
    System.out.println(MANUAL_LOTTO_COUNT_STR);
    String input = scanner.nextLine();
    emptyOrNullCheck(input);
    return Integer.parseInt(input);
  }

  public static List<List<Integer>> getManualLottoNumber(int count) {
    List<List<Integer>> manualList = new ArrayList<>();
    System.out.println(MANUAL_LOTTO_NUMBER_STR);
    for (int i = 1; i <= count; i++) {
      String numbers = scanner.nextLine();
      emptyOrNullCheck(numbers);
      manualList.add(LottoGenerator.getLottoNumberListFromString(numbers));
    }
    return manualList;
  }

  private static void emptyOrNullCheck(String input) {
    if (input == null || "".equals(input)) {
      throw new IllegalArgumentException(EMPTY_VALUE_ERROR_MESSAGE);
    }
  }
}
