package lotto.domain.item;

import enums.LottoPrize;
import lotto.domain.Money;
import lotto.exception.CloneFailException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTickets implements Cloneable {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = Collections.unmodifiableList(new ArrayList<>(tickets));
    }

    private int findWinLotto(LottoPrize lottoPrize, Item winTicket) {
        return (int) tickets.stream()
                .filter(ticket -> lottoPrize == ticket.getRank(winTicket))
                .count();
    }

    public int getFirstLottoCount(Item winTicket) {
        return findWinLotto(LottoPrize.FIRST, winTicket);
    }

    public int getSecondLottoCount(Item winTicket) {
        return findWinLotto(LottoPrize.SECOND, winTicket);
    }

    public int getThirdLottoCount(Item winTicket) {
        return findWinLotto(LottoPrize.THIRD, winTicket);
    }

    public int getFourthLottoCount(Item winTicket) {
        return findWinLotto(LottoPrize.FOURTH, winTicket);
    }

    public int getFifthLottoCount(Item winTicket) {
        return findWinLotto(LottoPrize.FIFTH, winTicket);
    }

    public Money getAllEarningPrize(Item winTicket) {
        Money earning = new Money();

        return earning
                .plus(LottoPrize.FIRST.getWinningPrize(getFirstLottoCount(winTicket)))
                .plus(LottoPrize.SECOND.getWinningPrize(getSecondLottoCount(winTicket)))
                .plus(LottoPrize.THIRD.getWinningPrize(getThirdLottoCount(winTicket)))
                .plus(LottoPrize.FOURTH.getWinningPrize(getFourthLottoCount(winTicket)))
                .plus(LottoPrize.FIFTH.getWinningPrize(getFifthLottoCount(winTicket)));
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int size(){
        return this.tickets.size();
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
