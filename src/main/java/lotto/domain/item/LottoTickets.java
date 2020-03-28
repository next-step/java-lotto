package lotto.domain.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT3 = 3;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT4 = 4;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT5 = 5;
    private static final int LOTTO_MATCH_LUCKY_NUMBER_COUNT6 = 6;

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        List<LottoTicket> tmp = new ArrayList<>();
        tmp.addAll(tickets);
        this.tickets = Collections.unmodifiableList(tmp);
    }

    private int getLuckyNumberMatchCount(int luckyNumber, List<Integer> luckyNumbers) {
        return (int) tickets.stream()
                .filter(ticket -> luckyNumber == ticket.getLuckyNumberMatchCount(luckyNumbers))
                .count();
    }

    public int getLuckyNumberMatch3Count(List<Integer> luckyNumbers) {
        return getLuckyNumberMatchCount(LOTTO_MATCH_LUCKY_NUMBER_COUNT3, luckyNumbers);
    }

    public int getLuckyNumberMatch4Count(List<Integer> luckyNumbers) {
        return getLuckyNumberMatchCount(LOTTO_MATCH_LUCKY_NUMBER_COUNT4, luckyNumbers);
    }

    public int getLuckyNumberMatch5Count(List<Integer> luckyNumbers) {
        return getLuckyNumberMatchCount(LOTTO_MATCH_LUCKY_NUMBER_COUNT5, luckyNumbers);
    }

    public int getLuckyNumberMatch6Count(List<Integer> luckyNumbers) {
        return getLuckyNumberMatchCount(LOTTO_MATCH_LUCKY_NUMBER_COUNT6, luckyNumbers);
    }

//    public boolean getAllEarningPrize(List<Integer> luckyNumbers) {
//        Money lottoPrice = new Money(LOTTO_PRICE);
//        Money earning = new Money();
//
//        earning = earning
//                .plus(LottoPrize.MATCH3.calculate(getLuckyNumberMatch3Count(luckyNumbers)))
//                .plus(LottoPrize.MATCH4.calculate(getLuckyNumberMatch4Count(luckyNumbers)))
//                .plus(LottoPrize.MATCH5.calculate(getLuckyNumberMatch5Count(luckyNumbers)))
//                .plus(LottoPrize.MATCH6.calculate(getLuckyNumberMatch6Count(luckyNumbers)));
//
//        return (earning.getMoney() / (this.money.getHowManyBuyItem(lottoPrice) * lottoPrice.getMoney()) * 100);
//    }
}
