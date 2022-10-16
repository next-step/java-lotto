package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTestCalculateStrategy implements LottoCalculateStrategy {
    @Override
    public int calculateLottoTicketCount(Money money) {
        return 0;
    }

    @Override
    public List<List<LottoNumber>> buyLottoes(int ticketCount) {
        List<List<LottoNumber>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(new LottoNumber(1));
        return list;
    }

    @Override
    public Statistics calculateStatistics(List<List<LottoNumber>> lottoes, List<LottoNumber> winningLottoes, Money buyAmount) {
        Map<WinningPrize, Integer> winningStats = new HashMap<>();
        winningStats.put(WinningPrize.THREE, 1);
        double earningRate = 0.0;
        return new Statistics(winningStats, earningRate);
    }

}
