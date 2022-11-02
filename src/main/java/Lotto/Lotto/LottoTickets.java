package Lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    LottoTickets(LottoMoney lottoMoney) {
        lottoTickets = IntStream.range(0, lottoMoney.getLottoCount())
                .mapToObj(num -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }
}
