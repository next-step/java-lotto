package lotto.ui;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Winning;

public class ResultView {

  private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private static final String EMPTY = "";

  public void printChange(Money change) {
    Printer.print(String.format("거스름 돈 %s원이 반환 됩니다.", change));
  }

  public void showTicketsInfo(LottoTickets lottoTickets) {
    List<LottoTicket> tickets = lottoTickets.tickets();

    for (LottoTicket ticket : tickets) {
      Printer.print(
          ticket.numbers().stream()
              .map(number -> Integer.toString(number.value()))
              .collect(Collectors.joining(", ", "[", "]")));
    }
  }

  public void printPurchaseAmount(int ticketPurchasableNumber) {
    Printer.print(ticketPurchasableNumber + "개를 구매했습니다.");
  }

  public void printResult(Map<Winning, Integer> winnings, double profit) {
    Printer.print("당첨 통계\n---------");

    for (Winning winning : Winning.values()) {
      Printer.print(String.format("%d개 일치 (%d원)- %d개",
          winning.sameCount(), winning.reward(), winnings.get(winning)));
    }

    String suffix = EMPTY;

    if (profit < 1) {
      suffix = LOSS_MESSAGE;
    }

    Printer.print(String.format("총 수익률은 %.2f입니다.%s", profit, suffix));
  }
}
