package lotto.view;

import lotto.domain.Lottery;
import lotto.domain.LottoBall;
import lotto.domain.LottoBalls;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  static public int amountTotal() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(new Scanner(System.in).nextLine());
  }

  static public Lottery lottery() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    String normalBallsInput = scanner.nextLine();
    System.out.println("보너스 번호를 입력해주세요.");
    String bonusBallInput = scanner.nextLine();

    return Lottery.of(LottoBall.of(Integer.parseInt(bonusBallInput)),
            LottoBalls.of(Arrays.stream(parseLotteryBalls(normalBallsInput)).map(ball -> LottoBall.of(Integer.parseInt(ball))).collect(Collectors.toList())));
  }

  private static  String[] parseLotteryBalls(String lotteryBalls) {
    return lotteryBalls.replace(" ", "").split(",");
  }
}
