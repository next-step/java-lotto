package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTestCalculateStrategy implements LottoCalculateStrategy {
    @Override
    public int countLottoTickets(Money money) {
        return 0;
    }

    @Override
    public Money getTicketPrice() {
        return new Money(1000);
    }

    @Override
    public List<SelectedLottoes> buyLottoTickets(int ticketCount) {
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        SelectedLottoes selectedLottoes = new SelectedLottoes(list);
        List<SelectedLottoes> list2 = new ArrayList<>();
        list2.add(selectedLottoes);
        return list2;
    }

    @Override
    public Statistics calculateStatistics(List<SelectedLottoes> lottoes, LottoWinningStrategy winningLottoes, Money buyAmount) {
        Map<RANK, Integer> winningStats = new HashMap<>();
        winningStats.put(RANK.THREE, 1);
        double earningRate = 0.0;
        return new Statistics(winningStats, earningRate);
    }

}
