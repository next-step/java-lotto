package lotto.domain.lottoGenerator;

import lotto.domain.LottoTicket;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ManualLottoTicketsGenerator implements LottoTicketsGenerator {

    private final List<String> manuallyPickedLottoTickets;

    public ManualLottoTicketsGenerator(List<String> manuallyPickedLottoTickets) {
        this.manuallyPickedLottoTickets = manuallyPickedLottoTickets;
    }

    @Override
    public List<LottoTicket> generate() {
        return manuallyPickedLottoTickets.stream()
                .map(LottoTicket::from)
                .collect(toList());
    }

}
