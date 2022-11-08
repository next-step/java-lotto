package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningLotto {
    private final LottoTicket ticket;
    private final LottoNumber bonusNumber;

    public WinningLotto(final LottoTicket ticket, final LottoNumber bonus) {
        if (ticket.hasNumber(bonus)) {
            throw new IllegalArgumentException("이미 뽑힌 번호입니다");
        }
        this.ticket = ticket;
        this.bonusNumber = bonus;
    }

    public WinningLotto(final List<Integer> ticketNumbers, final int bonus) {
        this(LottoTicket.createFromIntegerList(ticketNumbers), new LottoNumber(bonus));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(ticket, that.ticket) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, bonusNumber);
    }

    public List<LottoPrize> prizes(final List<LottoTicket> tickets) {
        return tickets.stream()
                .map(this::prize)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<LottoPrize> prize(final LottoTicket ticket) {
        return LottoPrize.find(ticket.getTheNumberOfCommonNumbers(this.ticket), ticket.hasNumber(this.bonusNumber));
    }
}
