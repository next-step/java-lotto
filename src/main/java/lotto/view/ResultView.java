package lotto.view;


import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ResultView {

  private static final Long DEFAULT_VALUE = 0L;

  public static void printBuyCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public static void printTickets(List<LottoTicket> tickets) {
    tickets.forEach(System.out::println);
  }

  public static void printRanks(Map<Rank, Long> ranks) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    Stream.of(Rank.values())
        .filter(rank -> rank.getCountOfMatch() > 0)
        .forEach(rank -> {
          System.out.println(rank.getCountOfMatch() + "개 일치 ("
              + rank.getWinningMoney() + "원) - " + ranks.getOrDefault(rank, DEFAULT_VALUE) + "개");
        });
  }
}
