package study.lottogame.ui;

import java.util.Scanner;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.LottoNumber;
import study.lottogame.domain.Money;
import study.lottogame.factory.LotteryFactory;
import study.lottogame.util.StringUtils;

public class InputView {

  private InputView() {
  }

  private static final String LOTTO_DELIMITER = ",";
  private static final Scanner sc = new Scanner(System.in);

  public static Money inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요.");
    int money = Integer.parseInt(getInput().trim());
    return new Money(money);
  }

  public static int inputManualLotteryCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    int count = Integer.parseInt(getInput().trim());
    return count;
  }

  public static void inputManualLotteries(int count, Lotteries lotteries) {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    for (int i = 0; i < count; i++) {
      Lottery lottery = InputAndCreateLottery();
      lotteries.addLottery(lottery);
    }
  }

  public static Lottery inputPrizeLottery() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return InputAndCreateLottery();
  }

  private static Lottery InputAndCreateLottery() {
    String[] numbers = getInput().split(LOTTO_DELIMITER);
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
