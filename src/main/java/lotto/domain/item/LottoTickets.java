package lotto.domain.item;

import enums.Rank;
import lotto.domain.Money;
import lotto.domain.strategy.LottoNumberAutoGenerator;
import lotto.exception.CloneFailException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets implements Cloneable {

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = Collections.unmodifiableList(new ArrayList<>(tickets));
    }

    public static LottoTickets createLottoToAuto(int count) {
        List<LottoTicket> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = LottoNumbers.createLottoNumbersUseInteger(LottoNumberAutoGenerator.generateLottoNumber());
            result.add(new LottoTicket(numbers));
        }
        return new LottoTickets(result);
    }

    public static LottoTickets createLottoToPassivity(List<LottoNumbers> numbers) {
        List<LottoTicket> tickets = numbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
        return new LottoTickets(tickets);
    }

    public int findWinLottoCountFromRank(Rank rank, WinLottoTicket winTicket) {
        return (int) tickets.stream()
                .filter(ticket -> rank == ticket.getRank(winTicket))
                .count();
    }

    public Money getAllEarningPrize(WinLottoTicket winTicket) {
        Money earning = new Money();

        return earning
                .plus(Rank.FIRST.getWinningPrize(findWinLottoCountFromRank(Rank.FIRST, winTicket)))
                .plus(Rank.SECOND.getWinningPrize(findWinLottoCountFromRank(Rank.SECOND, winTicket)))
                .plus(Rank.THIRD.getWinningPrize(findWinLottoCountFromRank(Rank.THIRD, winTicket)))
                .plus(Rank.FOURTH.getWinningPrize(findWinLottoCountFromRank(Rank.FOURTH, winTicket)))
                .plus(Rank.FIFTH.getWinningPrize(findWinLottoCountFromRank(Rank.FIFTH, winTicket)));
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int size() {
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

    @Override
    public String toString() {
        return tickets.toString();
    }
}
