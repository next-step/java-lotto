package lotto;

import java.util.List;

public interface LottoCalculateStrategy {
    int calculateLottoTicketCount(Money money);

    List<List<Lotto>> buyLottoes(int ticketCount);

    Statistics calculateStatistics(List<List<Lotto>> lottoes, List<Lotto> winningLottoes, Money buyAmount);
}
