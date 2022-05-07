package study.step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static study.step2.domain.LottoNumbers.lottoNumbers;

public class LottoGame {
    private final int LOTTO_MAX_NUBMER = 6;

    private final LottoTickets tickets;

    public LottoGame(int count) {
        new LottoNumbers();
        this.tickets = new LottoTickets(purchaseTickets(count));
    }

    public LottoTicket purchaseSingleTicket() {
        List<Integer> singleTicket = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < LOTTO_MAX_NUBMER; i++) {
            singleTicket.add(lottoNumbers.get(i));
        }
        Collections.sort(singleTicket);
        return new LottoTicket(singleTicket);
    }

    public List<LottoTicket> purchaseTickets(int count) {
        List<LottoTicket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ticketList.add(purchaseSingleTicket());
        }
        return ticketList;
    }

    public LottoTickets getTickets() {
        return tickets;
    }
}
