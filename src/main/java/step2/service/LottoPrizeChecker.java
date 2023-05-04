package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.entity.LottoTicket;
import step2.domain.vo.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class LottoPrizeChecker {

    public static List<LottoPrize> checker(List<LottoTicket> tickets, Lotto winner) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (LottoTicket ticket : tickets) {
            final var count = winner.countSameNumber(ticket.getLotto());
            final var prize = LottoPrize.prize(count);
            prizes.add(prize);
        }

        return prizes;
    }
}
