package step2;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class LottoSalesman {

  private static final Function<Scanner, Integer> AMOUNT_QUEST = (s) -> s.nextInt();
  private static final String SCRIP_AMOUNT = "구입금액을 입력해 주세요.";

  private static final Function<Scanner, String> WINNING_NUMBER_QUEST = (s) -> s.next();
  private static final String SCRIPT_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";

  private static final String SCRIPT_INFORM_WINNING = "\n당첨 통계";

  public static int purchaseAmount(Scanner scanner) {
    System.out.println(SCRIP_AMOUNT);
    return AMOUNT_QUEST.apply(scanner);
  }

  public static void informPurchase(List<Lotto> lottos) {
    System.out.println(String.format("%d개를 구매했습니다.", lottos.size()));
    for (Lotto lotto : lottos) {
      System.out.println(lotto.numbers);
    }
  }

  public static String winningNumber(Scanner scanner) {
    System.out.println(SCRIPT_WINNING_NUMBER);
    return WINNING_NUMBER_QUEST.apply(scanner);
  }

  public static void informWinning(Scanner scanner, LottoStats analyze, int payment) {
    System.out.println(SCRIPT_INFORM_WINNING);
    System.out.println("--------");
    System.out.print(analyze);
    System.out.printf("총 수익률은 %.2f입니다.", analyze.rate(payment));
  }

}
