package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(int number) {
        this.lottoTickets = createAuto(number);
    }

    private List<LottoTicket> createAuto(int number) {
        return IntStream.rangeClosed(1,number)
                .boxed()
                .map(lottoTicket->LottoFactory.createAutoLottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
