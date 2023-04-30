package view;

import java.util.List;
import java.util.Scanner;
import util.Converter;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static int scanMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public static List<Integer> scanWinningNumbers() {
    System.out.println();
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumbers = scanner.next();
    return Converter.convertToLottoNumbers(winningNumbers);
  }

}
