package lotto.view;

import java.util.Scanner;

public class InputView {

  public static int inputPriceOfBuy() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }
}
