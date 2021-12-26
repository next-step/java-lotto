package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private List<LottoTicket> values = new ArrayList<>();

    private LottoTickets(List<LottoTicket> values) {
        this.values = values;
    }

    public int count() {
        return values.size();
    }

    public LotteryResult calculate(WinningLottoNumbers winnings) {
        Map<Rank, Long> result = values.stream()
                .map(ticket -> ticket.rank(winnings))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return LotteryResult.from(result);
    }

    public static LottoTickets of(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    @Override
    public String toString() {
        return values.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
