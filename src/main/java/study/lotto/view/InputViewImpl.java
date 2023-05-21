package study.lotto.view;

import java.util.Scanner;
import study.lotto.model.LottoNumber;

public class InputViewImpl implements InputView{

  @Override
  public int getAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    int amount = scanner.nextInt();
    return amount;
  }

  @Override
  public LottoNumber previousWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return new LottoNumber(input);

  }
}
