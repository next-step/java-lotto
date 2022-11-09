package lotto.domain;

import java.util.List;

public class LottoEarningRateCalculator {

    public static float calculate(final List<LottoPrize> prizes, final int numberOfTickets) {
        int reward = prizes.stream()
                .map(LottoPrize::reward)
                .mapToInt(Integer::intValue)
                .sum();

        return (float) reward / LottoGame.getTicketCost(numberOfTickets);
    }
}
