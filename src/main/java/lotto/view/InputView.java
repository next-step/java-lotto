package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.collections.Money;
import lotto.collections.WinningNumbers;

public class InputView {

  public static final Scanner scanner = new Scanner(System.in);

  public static Money inputPurchaseMoney() {
    System.out.println("NextStep 로또게임에 오신 것을 환영합니다!");
    System.out.println("구매금액을 입력해 주세요.");
    return new Money(scanner.nextInt());
  }

  public static WinningNumbers inputLastWeekWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String winningNumber = scanner.next();
    List<Integer> winningNumberBeforeList = Arrays.stream(winningNumber.split(","))
        .map(String::trim)
        .map(Integer::valueOf)
        .collect(Collectors.toList());
    return new WinningNumbers(winningNumberBeforeList);
  }

}
