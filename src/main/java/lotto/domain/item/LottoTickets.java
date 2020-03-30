package lotto.domain.item;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.exception.CloneFailException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets implements Cloneable {

//    private final List<LottoTicket> tickets;
//
//    public LottoTickets(List<LottoTicket> tickets) {
//        this.tickets = Collections.unmodifiableList(new ArrayList<>(tickets));
//    }
//
//    public int findWinLottoCountFromRank(LottoPrize lottoPrize, Item winTicket) {
//        return (int) tickets.stream()
//                .filter(ticket -> lottoPrize == ticket.getRank(winTicket))
//                .count();
//    }
//
//    public Money getAllEarningPrize(Item winTicket) {
//        Money earning = new Money();
//
//        return earning
//                .plus(LottoPrize.FIRST.getWinningPrize(findWinLottoCountFromRank(LottoPrize.FIRST, winTicket)))
//                .plus(LottoPrize.SECOND.getWinningPrize(findWinLottoCountFromRank(LottoPrize.SECOND, winTicket)))
//                .plus(LottoPrize.THIRD.getWinningPrize(findWinLottoCountFromRank(LottoPrize.THIRD, winTicket)))
//                .plus(LottoPrize.FOURTH.getWinningPrize(findWinLottoCountFromRank(LottoPrize.FOURTH, winTicket)))
//                .plus(LottoPrize.FIFTH.getWinningPrize(findWinLottoCountFromRank(LottoPrize.FIFTH, winTicket)));
//    }
//
//    public List<LottoTicket> getTickets() {
//        return tickets;
//    }
//
//    public int size() {
//        return this.tickets.size();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        LottoTickets that = (LottoTickets) o;
//        return Objects.equals(tickets, that.tickets);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tickets);
//    }
//
//    @Override
//    protected LottoTickets clone() {
//        LottoTickets clone = null;
//        try {
//            clone = (LottoTickets) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new CloneFailException("객체 클론 실패");
//        }
//
//        return clone;
//    }
}
