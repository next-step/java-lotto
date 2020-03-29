package lotto.domain.item;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.exception.CloneFailException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class LottoTickets implements Cloneable {
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

    public Money getAllEarningPrize(List<Integer> luckyNumbers) {
        Money earning = new Money();

        return earning
                .plus(LottoPrize.FIFTH.getWinningPrize(getLuckyNumberMatch3Count(luckyNumbers)))
                .plus(LottoPrize.FOURTH.getWinningPrize(getLuckyNumberMatch4Count(luckyNumbers)))
                .plus(LottoPrize.SECOND.getWinningPrize(getLuckyNumberMatch5Count(luckyNumbers)))
                .plus(LottoPrize.FIRST.getWinningPrize(getLuckyNumberMatch6Count(luckyNumbers)));
    }


    public List<LottoTicket> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }

    @Override
    protected LottoTickets clone() {
        LottoTickets clone = null;
        try {
            clone = (LottoTickets) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneFailException("객체 클론 실패");
        }

        return clone;
    }
}
