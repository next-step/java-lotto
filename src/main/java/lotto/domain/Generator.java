package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    private LottoTicket generateLottoTicket() {
        List<Integer> numbers = LottoNumberMaker.makeNewNumbers();
        return new LottoTicket(numbers);
    }

    public List<LottoTicket> generateLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i <ticketCount ; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    public List<LottoTicket> generateManualLottoTicket(List<List<Integer>> manualLottoNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        manualLottoNumbers.forEach(n -> lottoTickets.add(new LottoTicket(n)));
        return lottoTickets;
    }
}
