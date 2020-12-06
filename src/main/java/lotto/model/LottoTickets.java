package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
            tickets.add(new LottoTicket(lottoNumberMaker.makeNumber()));
        }
        return new LottoTickets(tickets);
    }
    public static LottoTickets of(int ticketCount, String[] manualNumbers) {
        List<LottoTicket> tickets = new ArrayList<>();

        //수동번호
        for (int i = 0; i < manualNumbers.length; i++) {
            tickets.add(LottoTicket.of(manualNumbers[i]));
        }

        //자동번호
        for (int i = 0; i < ticketCount; i++) {
            LottoNumberMaker lottoNumberMaker = new LottoNumberMaker();
            tickets.add(new LottoTicket(lottoNumberMaker.makeNumber()));
        }



        return new LottoTickets(tickets);
    }

    public int getTicketCount() {
        return lottoTickets.size();
    }

    public LottoTicket oneOf(int count) {
        return lottoTickets.get(count);
    }
}
