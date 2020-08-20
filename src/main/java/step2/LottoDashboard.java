package step2;

public class LottoDashboard {

  private static final String SCRIPT_INFORM_WINNING = "\n당첨 통계";

  public static void informWinning(LottoStats analyze, int payment) {
    System.out.println(SCRIPT_INFORM_WINNING);
    System.out.println("--------");
    System.out.print(analyze);
    System.out.printf("총 수익률은 %.2f입니다.", analyze.rate(payment));
  }

}
