package view;

import domain.LottoBall;
import domain.LottoBalls;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  static public int amountTotal() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(new Scanner(System.in).nextLine());
  }

  static public LottoBalls winningBalls() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    String input = new Scanner(System.in).nextLine();
    return new LottoBalls(Arrays.stream(parseLotteryBalls(input)).map(ln -> LottoBall.of(Integer.parseInt(ln))).collect(Collectors.toList()));
  }

  private static  String[] parseLotteryBalls(String lotteryBalls) {
    return lotteryBalls.replace(" ", "").split(",");
  }
}
