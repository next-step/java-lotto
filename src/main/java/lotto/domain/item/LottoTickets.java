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
        List<LottoTicket> tmp = new ArrayList<>();
        tmp.addAll(tickets);
        this.tickets = Collections.unmodifiableList(tmp);
    }

    private int finWinLotto(LottoPrize lottoPrize, Item winTicket) {
        return (int) tickets.stream()
                .filter(ticket -> lottoPrize == ticket.getRank(winTicket))
                .count();
    }

    public int getFirstLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.FIRST, winTicket);
    }

    public int getSecondLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.SECOND, winTicket);
    }

    public int getThirdLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.THIRD, winTicket);
    }

    public int getFourthLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.FOURTH, winTicket);
    }

    public int getFifthLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.FIFTH, winTicket);
    }

    public int getMisshLottoCount(Item winTicket) {
        return finWinLotto(LottoPrize.MISS, winTicket);
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
