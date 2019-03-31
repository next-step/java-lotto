package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInputView {

  public int inputPurchaseAmount() {

    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public int inputManualQuantity() {

    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public List<String> inputManualNumbers(int manualQuantity) {

    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    Scanner scanner = new Scanner(System.in);
    return IntStream.range(0, manualQuantity)
        .mapToObj(quantity -> scanner.nextLine())
        .collect(Collectors.toList());
  }

  public String inputWinNumbers() {

    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return new Scanner(System.in).nextLine();
  }

  public int inputAdditionNumber() {

    System.out.println("보너스 볼을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }
}
