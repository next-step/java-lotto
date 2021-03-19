package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final LottoQuantity lottoQuantity;
    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyAmount) {
        this.lottoQuantity = new LottoQuantity(buyAmount);
        this.lottoTickets = createLottoTickets();
    }

    public LottoMachine(LottoQuantity lottoQuantity, List<LottoTicket> lottoTickets) {
        this.lottoQuantity = lottoQuantity;
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> createLottoTickets() {
        return Stream.generate(LottoTicket::new)
                .limit(lottoQuantity.lottoQuantity())
                .collect(Collectors.toList());
    }

    public int lottoQuantity() {
        return lottoQuantity.lottoQuantity();
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
