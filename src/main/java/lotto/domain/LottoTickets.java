package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private List<LottoNumbers> values = new ArrayList<>();

    private LottoTickets(List<LottoNumbers> values) {
        this.values = values;
    }

    public static LottoTickets of(List<LottoNumbers> tickets) {
        return new LottoTickets(tickets);
    }

    public List<LottoNumbers> getValues() {
        return values;
    }

    public int count() {
        return values.size();
    }

    public LotteryResult calculate(WinningLottoNumbers winnings) {
        Map<Rank, Long> result = values.stream()
                .map(ticket -> winnings.rank(ticket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return LotteryResult.from(result);
    }

    public LottoTickets add(LottoTickets tickets) {
        this.values.addAll(tickets.values);
        return LottoTickets.of(this.values);
    }
}
