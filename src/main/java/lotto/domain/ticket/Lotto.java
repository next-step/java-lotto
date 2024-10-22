package lotto.domain.ticket;

import lotto.application.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int LOTTO_TICKET_PRICE = 1000;
    private final LottoGenerator lottoGenerator;
    private final LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator();

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public int getLottoTicketCount(int purchasePrice) {
        return purchasePrice / LOTTO_TICKET_PRICE;
    }

    public LottoTickets issue(int autoLottoTicketCount, List<List<Integer>> passiveLottoNumbersList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        if (passiveLottoNumbersList.size() != 0) {
            lottoTickets = getPassiveLottoTickets(passiveLottoNumbersList);
        }

        for (int i = 0; i < autoLottoTicketCount; i++) {
            lottoTickets.add(lottoTicketGenerator.getAutoTicket(lottoGenerator));
        }

        return new LottoTickets(lottoTickets);
    }

    private List<LottoTicket> getPassiveLottoTickets(List<List<Integer>> passiveLottoNumbersList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < passiveLottoNumbersList.size(); i++) {
            lottoTickets.add(lottoTicketGenerator.getPassiveTicket(passiveLottoNumbersList.get(i)));
        }

        return lottoTickets;
    }

}
