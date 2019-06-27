package lotto.view;


import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinLotto;

import java.util.List;
import java.util.stream.Stream;

public class ResultView {

  private static final Long DEFAULT_VALUE = 0L;

  public static void printBuyCount(int buyLottoCount, int manualBuyLottoCount) {
    System.out.println("수동으로 " + manualBuyLottoCount + "개, 자동으로 " + buyLottoCount + "개를 구매했습니다.");
  }

  public static void printTickets(List<LottoTicket> tickets) {
    tickets.forEach(System.out::println);
  }

  public static void printRanks(WinLotto winLotto) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    Stream.of(Rank.values())
        .filter(rank -> rank.getCountOfMatch() > 0)
        .forEach(rank -> System.out.println(rank.printString() + " ("
            + rank.getWinningMoney() + "원) - " + winLotto.getOrDefault(rank, DEFAULT_VALUE) + "개"));
  }

  public static void printProfitRate(double rate) {
    System.out.printf("총 수익률은 %.2f 입니다.", rate);
  }
}
