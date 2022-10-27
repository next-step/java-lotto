package lotto;

import java.util.List;

public interface LottoCalculateStrategy {
    int countLottoTickets(Money money);

    List<SelectedLottoNumbers> buyLottoTickets(int ticketCount);

    Statistics calculateStatistics(List<SelectedLottoNumbers> lottoes, LottoWinningStrategy winningLottoes, Money buyAmount);
}
