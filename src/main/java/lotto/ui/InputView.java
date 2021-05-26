package lotto.ui;

import lotto.dto.OrderSheet;
import lotto.dto.WinningNumbersAndBonusNumber;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class InputView {

  private static final String PLEASE_INPUT_INTEGER = "자연수로 입력 해 주세요.";
  private static final String PLEASE_INPUT_PURCHASING_PRICE = "구입금액을 입력해 주세요.";
  private static final String PLEASE_INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
  private static final String PLEASE_INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
  private static final String PLEASE_INPUT_LAST_WEEK_PRIZE = "지난 주 당첨 번호를 입력해 주세요.";
  private static final String PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
  private static final Pattern SPACE = Pattern.compile("\\s");
  private static final Pattern COMMA = Pattern.compile(",");

  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

  public static OrderSheet orderNewGames() {
    long purchasingAmount = sayQuestionAndGetLong(PLEASE_INPUT_PURCHASING_PRICE);
    List<List<Integer>> manualLottoNumbers = getManualLottoNumbers(sayQuestionAndGetLong(PLEASE_INPUT_MANUAL_LOTTO_COUNT));
    return OrderSheet.of(purchasingAmount, manualLottoNumbers);
  }

  public static WinningNumbersAndBonusNumber inputWinningNumbersAndBonusNumber() {
    List<Integer> winningNumbers = sayQuestionAndGetIntegerList(PLEASE_INPUT_LAST_WEEK_PRIZE);
    int bonusNumber = (int) sayQuestionAndGetLong(PLEASE_INPUT_BONUS_NUMBER);
    return new WinningNumbersAndBonusNumber(winningNumbers, bonusNumber);
  }

  private static List<List<Integer>> getManualLottoNumbers(long sayQuestionAndGetLong) {
    if(sayQuestionAndGetLong > 0) {
      System.out.println(PLEASE_INPUT_MANUAL_LOTTO_NUMBERS);
      return LongStream.range(0, sayQuestionAndGetLong)
          .mapToObj(index -> getIntegerList())
          .collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  private static long sayQuestionAndGetLong(String question) {
    System.out.println(question);
    return getLongValue();
  }

  private static List<Integer> sayQuestionAndGetIntegerList(String question) {
    System.out.println(question);
    return getIntegerList();
  }

  private static List<Integer> getIntegerList() {
    String input = getStringValue();
    return parsInts(splitByDelimiter(input));
  }

  private static List<Integer> parsInts(String[] numberStrings) {
    return Arrays.stream(numberStrings)
            .map(InputView::parseInt)
            .collect(Collectors.toList());

  }

  private static int parseInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw new IllegalArgumentException(PLEASE_INPUT_INTEGER);
    }
  }

  private static String[] splitByDelimiter(String input) {
    String replaced = SPACE.matcher(input).replaceAll("");
    return COMMA.split(replaced);
  }

  private static long getLongValue() {
    try {
      return SCANNER.nextLong();
    } catch (InputMismatchException e) {
      throw new IllegalArgumentException(PLEASE_INPUT_INTEGER, e);
    } finally {
      SCANNER.nextLine();
    }
  }

  private static String getStringValue() {
    try {
      return SCANNER.next();
    } finally {
      SCANNER.nextLine();
    }
  }
}
