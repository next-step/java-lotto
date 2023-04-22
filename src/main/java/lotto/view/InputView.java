package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.LottoResult.PER_TICKET;

public class InputView {


  private static final Scanner scanner = new Scanner(System.in);
  private static final String DELIMITER = ",";

  private InputView() {
  }

  public static int inputTryCount() {
    System.out.println("구입금액을 입력해주세요. 100단위 이하는 생략됩니다.");
    int tryNumber = scanner.nextInt() / PER_TICKET;
    System.out.println(tryNumber + "개를 구매하셨습니다.");

    return tryNumber;
  }

  public static List<Integer> inputWinningTicketNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return Arrays.stream(scanner.next().split(DELIMITER))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }
}
