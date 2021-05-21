package lotto.utils;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerNumbers;
import lotto.domain.WinnerStatistics;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoLotteryUtils {

    public static WinnerStatistics lotteryThisWeek(List<LottoTicket> lottoTickets, WinnerNumbers winnerNumbers) {
        Map<LottoRank, Long> lotteryResylt = lottoTickets.stream()
                .map(lottoTicket -> winnerNumbers.matchCount(lottoTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return WinnerStatistics.create(lotteryResylt);
    }
}
