package lotto3.view;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto3.domain.LottoNumber;
import lotto3.domain.LottoNumbers;
import lotto3.domain.LottoTicket;
import lotto3.domain.LottoTickets;
import lotto3.domain.ManualLottoCount;
import lotto3.domain.Money;

public class InputView {

  private static final String DELIMITER = ",\\s*";
  private static final Scanner SCANNER = new Scanner(System.in);

  public static Money scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    String investMoney = SCANNER.nextLine();
    validateMoney(investMoney);
    return new Money(Integer.parseInt(investMoney));
  }

  private static void validateMoney(String investMoney) {
    if (isBlank(investMoney)) {
      throw new IllegalArgumentException("구입금액을 입력해 주세요.");
    }
    if (isNotNumber(investMoney)) {
      throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
    }
  }


  private static boolean isNotNumber(String investMoney) {
    return !investMoney.matches("^[0-9]*$");
  }

  public static LottoNumbers scanWinningNumbers() {
    System.out.println();
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumbers = SCANNER.nextLine();
    validateBlank(winningNumbers);
    return convertLottoNumbers(winningNumbers);
  }

  private static void validateBlank(String winningNumbers) {
    if (isBlank(winningNumbers)) {
      throw new IllegalArgumentException("지난 주 당첨 번호를 입력해 주세요.");
    }
  }


  private static boolean isBlank(String winningNumbers) {
    return winningNumbers == null || winningNumbers.isBlank();
  }

  private static LottoNumbers convertLottoNumbers(String winningNumbers) {
    String[] splitNumbers = splitWithDelimiter(winningNumbers);
    List<Integer> numbers = convertIntegerList(splitNumbers);
    return new LottoNumbers(numbers);
  }

  private static List<Integer> convertIntegerList(String[] splitNumbers) {
    return Arrays.stream(splitNumbers)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  private static String[] splitWithDelimiter(String winningNumbers) {
    return winningNumbers.split(DELIMITER);
  }

  public static LottoNumber scanBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    String bonusNumber = SCANNER.nextLine();
    validateBlank(bonusNumber);
    validateIsNumber(bonusNumber);
    return new LottoNumber(Integer.parseInt(bonusNumber));
  }

  private static void validateIsNumber(String bonusNumber) {
    if (!isNotNumber(bonusNumber)) {
      throw new IllegalArgumentException("보너스 볼은 숫자만 입력 가능합니다.");
    }
  }


  public static ManualLottoCount scanManualCount() {
    System.out.println();
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    String manualCount = SCANNER.nextLine();
    validateManualCountBlank(manualCount);
    validateManualCountIsNumber(manualCount);
    return new ManualLottoCount(Integer.parseInt(manualCount));
  }

  private static void validateManualCountIsNumber(String manualCount) {
    if (!isNotNumber(manualCount)) {
      throw new IllegalArgumentException("수동으로 구매할 로또 수는 숫자만 입력 가능합니다.");
    }
  }

  private static void validateManualCountBlank(String manualCount) {
    if (isBlank(manualCount)) {
      throw new IllegalArgumentException("수동으로 구매할 로또 수를 입력해 주세요.");
    }
  }

  public static LottoTickets scanManualLottoNumbers(ManualLottoCount manualLottoCount) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    int count = manualLottoCount.getCount();

    List<LottoTicket> lottoTickets = new ArrayList<>();
    for(int i = 0; i < count; i++) {
      String manualLottoNumbers = SCANNER.nextLine();
      validateManualLottoNumbersIsBlank(manualLottoNumbers);
      LottoTicket lottoTicket = convertToLottoTicket(manualLottoNumbers);
      lottoTickets.add(lottoTicket);
    }

    return new LottoTickets(lottoTickets);
  }

  private static LottoTicket convertToLottoTicket(String manualLottoNumbers) {
    String[] splitManualLottoNumbers = splitWithDelimiter(manualLottoNumbers);
    validateManualLottoNumbersIsNumber(splitManualLottoNumbers);
    List<Integer> manualNumbers = convertIntegerList(splitManualLottoNumbers);
    return new LottoTicket(manualNumbers);
  }

  private static void validateManualLottoNumbersIsNumber(String[] manualLottoNumbers) {
    for (String manualLottoNumber : manualLottoNumbers) {
      validateManualLottoNumberIsNumber(manualLottoNumber);
    }
  }

  private static void validateManualLottoNumberIsNumber(String manualLottoNumber) {
    if (!isNotNumber(manualLottoNumber)) {
      throw new IllegalArgumentException("수동으로 구매할 번호는 숫자만 입력 가능합니다.");
    }
  }

  private static void validateManualLottoNumbersIsBlank(String manualLottoNumbers) {
    if (isBlank(manualLottoNumbers)) {
      throw new IllegalArgumentException("수동으로 구매할 번호를 입력해 주세요.");
    }
  }
}
