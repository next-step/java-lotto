package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets publishTickets(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets publishTickets(Price price) {
        return new LottoTickets(createTickets(price));
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getDetailTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    private static List<LottoTicket> createTickets(Price price) {
        int numberOfTickets = price.getNumberOfTickets();
        List<LottoTicket> lottoTickets = new ArrayList<>(numberOfTickets);

        for (int i = 0; i < numberOfTickets; i++) {
            lottoTickets.add(createTicket());
        }

        return lottoTickets;
    }

    private static LottoTicket createTicket() {
        return LottoTicket.createTicket(
                LottoNumberGenerator.generateLottoNumbers());
    }

}
