package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class ResultView {

  public static void showLottos(List<Lotto> tickets) {
    System.out.println(tickets.size() + "개를 구매했습니다.");
    tickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
  }

  public static void printResults(Map<Integer, Long> results, double profitRate) {
    System.out.println("당첨 통계");
    System.out.println("---------");

    for(int i = 3; i < 7; i++){
      System.out.println( i + "개 일치 (" + getPrize(i) + "원)- " + results.getOrDefault(i, 0L) + "개");
    }

    System.out.printf("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 %s라는 의미임)\n",
        profitRate, profitRate >= 1 ? "이득" : "손해");
  }

  private static int getPrize(int matchCount) {
    int reward = 0;

    switch (matchCount) {
      case 3:
        reward = 5000;
        break;
      case 4:
        reward = 50000;
        break;
      case 5:
        reward = 1500000;
        break;
      case 6:
        reward = 2000000000;
        break;
      default:
        reward = 0;
    }
    return reward;
  }
}
