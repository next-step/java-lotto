package view;

import domain.LottoNumber;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInputView {

  public static int inputMoney() {
    System.out.println("구입금액을 입력해 주세요.");
    return new Scanner(System.in).nextInt();
  }

  public static List<LottoNumber> inputLastWeekWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력 해 주세요");
    String lastWeekWinningNumbers = new Scanner(System.in).nextLine();
    System.out.println(lastWeekWinningNumbers);
    return Stream.of(lastWeekWinningNumbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
  }

}
