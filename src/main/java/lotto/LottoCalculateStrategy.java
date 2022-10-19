package lotto;

import java.util.List;

public interface LottoCalculateStrategy {
    int countLottoTickets(Money money);

    Money getTicketPrice();

    List<SelectedLottoes> buyLottoTickets(int ticketCount);

    Statistics calculateStatistics(List<SelectedLottoes> lottoes, LottoWinningStrategy winningLottoes, Money buyAmount);
}
