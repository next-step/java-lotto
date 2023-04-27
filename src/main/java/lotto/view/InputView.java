package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.Price.buyTickets;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);
  private static final String DELIMITER = ",";

  private InputView() {
  }

  public static int inputTryCount() {
    System.out.println("구입금액을 입력해주세요. 100단위 이하는 생략됩니다.");

    return buyTickets(scanner.nextInt());
  }

  public static int inputDirectTryCount(int tryTotalCount) {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

    return validateDirectTryCount(scanner.nextInt(), tryTotalCount);
  }

  public static List<List<Integer>> inputDirectLottoNumbers(int tryDirectInputCount, int tryTotalCount) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    List<List<Integer>> directLottoNumbers = new ArrayList<>();
    for (int i = 0; i < tryDirectInputCount; i++) {
      directLottoNumbers.add(inputLottoNumbers());
    }

    System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.", tryDirectInputCount, tryTotalCount - tryDirectInputCount);
    System.out.println();

    return directLottoNumbers;
  }

  public static List<Integer> inputWinningTicketNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return inputLottoNumbers();
  }

  public static int inputBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");

    return scanner.nextInt();
  }

  private static List<Integer> inputLottoNumbers() {
    return Arrays.stream(scanner.next().split(DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }

  private static int validateDirectTryCount(int directTryCount, int tryTotalCount) {
    if (directTryCount > tryTotalCount) {
      throw new IllegalArgumentException("총 구매액이 수동로또 구매액에 비해 부족합니다.");
    }

    return directTryCount;
  }
}
