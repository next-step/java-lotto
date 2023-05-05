package study.lottogame.ui;

import java.util.Scanner;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.factory.LotteryFactory;
import study.lottogame.util.StringUtils;

public class InputView {

  private static final Scanner sc = new Scanner(System.in);

  public static Money inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요.");
    int money = Integer.parseInt(getInput().trim());
    return new Money(money);
  }

  public static Lottery inputPrizeLottery() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String[] numbers = getInput().split(",");
    return LotteryFactory.create(numbers);
  }

  public static LottoNumber inputBonusLottoNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    int lottoNumber = Integer.parseInt(getInput().trim());
    return LottoNumber.valueOf(lottoNumber);
  }

  private static String getInput() {
    String input = sc.nextLine();
    StringUtils.checkNullOrBlank(input);
    return input;
  }
}
