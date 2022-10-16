package lotto;

import java.util.List;

public interface LottoCalculateStrategy {
    int calculateLottoTicketCount(Money money);

    List<List<LottoNumber>> buyLottoes(int ticketCount);

    Statistics calculateStatistics(List<List<LottoNumber>> lottoes, List<LottoNumber> winningLottoes, Money buyAmount);
}
