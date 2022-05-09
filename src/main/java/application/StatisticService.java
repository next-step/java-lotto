package application;

import constants.LottoConstant;
import domain.LottoTicket;
import domain.WinStatistic;

import java.util.ArrayList;
import java.util.List;

public class StatisticService {

    private final List<WinStatistic> statistics = new ArrayList<>();

    public List<WinStatistic> initiateStatistics() {
        statistics.add(new WinStatistic(3, 0, 5000));
        statistics.add(new WinStatistic(4, 0, 50000));
        statistics.add(new WinStatistic(5, 0, 1500000));
        statistics.add(new WinStatistic(6, 0, 2000000000));

        return statistics;
    }

    public int getNumberOfMatches(LottoTicket lottoTicket, List<Integer> winningNumbers) {
        winningNumbers.removeAll(lottoTicket.getLottoNumbers());
        return (LottoConstant.MAX_LOTTO_NUMBERS - winningNumbers.size());
    }
}
