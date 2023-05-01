package lotto.ui;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public class ResultView {

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
}
