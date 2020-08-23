package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.utils.CommonConstant.NUMBER_ZERO;

public class LottoTickets {

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
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public List<LottoTicket> createManualLottoTicket(List<Integer> manualLottoNumbers, int lottoTicketQuantity) {
        for (int i = NUMBER_ZERO; i < lottoTicketQuantity; i++) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(manualLottoNumbers);
            LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
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
