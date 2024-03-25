package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

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

  public static void printOutInputMessage(final String message) {
    System.out.println(message);
  }

  public static String inputLine() {
    return scanner.nextLine();
  }

  public static String inputTotalAmount() {
    printOutInputMessage("구입 금액을 입력해 주세요.");
    return inputLine();
  }

  public static String inputCountManual() {
    printOutInputMessage("수동으로 구매할 로또 수를 입력해 주세요.");
    return inputLine();
  }

  public static String[] inputManualLottoNumbers(final PositiveNumber count) {
    printOutInputMessage("수동으로 구매할 번호를 입력해 주세요.");

    String[] lottos = new String[count.value()];
    IntStream.range(0, count.value())
            .forEach(i -> { lottos[i] = inputLine(); });

    return lottos;
  }
}
