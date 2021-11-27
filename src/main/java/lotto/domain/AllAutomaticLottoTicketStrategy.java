package lotto.domain;

import lotto.domain.value.LottoTicket;
import lotto.domain.value.Price;
import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllAutomaticLottoTicketStrategy implements GenerateLottoTicketStrategy {

    public AllAutomaticLottoTicketStrategy() {
    }

    @Override
    public List<LottoTicket> publishTickets(Price price) {
        int numberOfTickets = price.getNumberOfTickets();
        List<LottoTicket> lottoTickets = new ArrayList<>(numberOfTickets);

        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(createTicket());
        }

        return Collections.unmodifiableList(lottoTickets);
    }

    private LottoTicket createTicket() {
        return LottoTicket.createTicket(
                LottoNumberGenerator.generateLottoNumbers());
    }
}
