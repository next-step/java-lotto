package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.entity.LottoTicket;
import step2.domain.vo.LottoPrize;
import step2.domain.vo.Number;

import java.util.List;

public class LottoPrizeChecker {

    public static void checker(List<LottoTicket> tickets, Lotto winner) {
        for (LottoTicket ticket : tickets) {
            final var count = sameNumberCount(ticket.getLotto(), winner);
            final var prize = LottoPrize.prize(count);
            ticket.changeLottoPrizeStatus(prize);
        }
    }

    private static int sameNumberCount(Lotto winner, Lotto compare) {
        return sameNumberCount(winner.getLottoNumbers(), compare.getLottoNumbers());
    }

    private static int sameNumberCount(List<Number> winners, List<Number> compares) {
        return (int) winners.stream()
                .filter(compares::contains)
                .count();
    }
}
