package view;

import domain.LotteryNumber;
import domain.LotteryNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  static public int amountTotal() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(new Scanner(System.in).nextLine());
  }

  static public LotteryNumbers winningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해주세요.");
    String input = new Scanner(System.in).nextLine();
    return new LotteryNumbers(Arrays.stream(parseLotteryNumbers(input)).map(ln -> LotteryNumber.of(Integer.parseInt(ln))).collect(Collectors.toList()));
  }

  private static  String[] parseLotteryNumbers(String lotteryNumbers) {
    return lotteryNumbers.replace(" ", "").split(",");
  }
}
