package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    public static final int NUMBER_ZERO = 0;
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<Integer> manualLottoNumbers, int lottoTicketQuantity) {
        this.lottoTickets = new ArrayList<>();
        this.lottoTickets = createManualLottoTicket(manualLottoNumbers, lottoTicketQuantity);
    }

    public LottoTickets(int lottoTicketQuantity) {
        this.lottoTickets = new ArrayList<>();
        this.lottoTickets = createAutomaticLottoTicket(lottoTicketQuantity);
    }

    public List<LottoTicket> createAutomaticLottoTicket(int lottoTicketQuantity) {
        for (int i = NUMBER_ZERO; i < lottoTicketQuantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public List<LottoTicket> createManualLottoTicket(List<Integer> lottoTestList, int lottoTicketQuantity) {
        for (int i = NUMBER_ZERO; i < lottoTicketQuantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(lottoTestList);
            LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public long count() {
        return lottoTickets.stream()
                .count();
    }

}
