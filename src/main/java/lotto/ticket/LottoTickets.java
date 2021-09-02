package lotto.ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    //TODO: 본 생성자 지워야 하는지 확인 -> 서비스의 유연성을 위해 둬도 되지 않을까? 클라이언트에서 아래의 생성자를 호출한다면 문제가 없을 것 같은데.
    public LottoTickets(int[][] numbers) {
        this(Arrays.stream(numbers)
                .map(LottoTicket::new)
                .collect(Collectors.toList()));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<LottoTicket> value() {
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
}
