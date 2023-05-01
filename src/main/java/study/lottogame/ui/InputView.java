package study.lottogame.ui;

import java.util.List;
import java.util.Scanner;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.util.LottoNumbersGenerator;
import study.lottogame.util.StringUtils;

public class InputView {

  private static final Scanner sc = new Scanner(System.in);

  public static Money inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요.");
    String input = getInput();
    return new Money(Integer.parseInt(input));
  }

  public static List<LottoNumber> inputWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String input = getInput();
    return LottoNumbersGenerator.generate(input.split(","));
  }

  private static String getInput() {
    String input = sc.nextLine();
    StringUtils.checkNullOrBlank(input);
    return input;
  }
}
