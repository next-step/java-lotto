package lotto.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoEarningCalculator {
    public static List<LottoPrize> findPrize(final List<LottoTicket> tickets, final LottoTicket winningTicket) {
        return tickets.stream()
                .map(lottoTicket -> lottoTicket.getTheNumberOfCommonNumbers(winningTicket))
                .map(LottoPrize::findByCommonNumberCount)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public static float calculateEarningRate(final List<LottoPrize> prizes, final int numberOfTickets) {
        int reward = prizes.stream()
                .map(LottoPrize::getReward)
                .mapToInt(Integer::intValue)
                .sum();

        return (float) reward / LottoGame.getTicketCost(numberOfTickets);
    }
}
