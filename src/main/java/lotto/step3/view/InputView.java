package lotto.step3.view;

import lotto.step3.domain.LottoNumber;

import java.util.Scanner;

public class InputView {

  private static InputView instance;
  private final Scanner scanner;

  private InputView () {
    this.scanner = new Scanner(System.in);
  }

  public int inputPrice () {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public String inputWinning () {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public LottoNumber inputBonus () {
    System.out.println("보너스 볼을 입력해 주세요.");
    return LottoNumber.of(scanner.nextLine());
  }

  public static InputView getInstance () {
    if (instance == null) instance = new InputView();
    return instance;
  }
}
