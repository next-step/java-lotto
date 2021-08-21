package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<Ticket> lottoTickets = new ArrayList<>();

    public void addLottoTicket(LottoNumbersGenerator lottoNumbersGenerator) {
        lottoTickets.add(lottoNumbersGenerator.generateLottoTicket());
    }

    public List<Ticket> getLottoTickets() {
        return lottoTickets;
    }

}
