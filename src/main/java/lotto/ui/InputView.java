package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class InputView {
  private static final String DELIMITER = ", ";
  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int readMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public List<Integer> readWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = scanner.nextLine();

    return Arrays.stream(input.split(DELIMITER))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public int readBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public LottoNumber readBonusLottoNumber() {
    return new LottoNumber(readBonusNumber());
  }
}
