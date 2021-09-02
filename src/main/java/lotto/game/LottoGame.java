package lotto.game;

import lotto.number.RandomNumbers;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private final Payments payments;
    private final LottoTickets tickets;

    //TODO: 본 생성자 지워야 하는지 확인 -> 서비스의 유연성을 위해 둬도 되지 않을까? 클라이언트에서 아래의 생성자를 호출한다면 문제가 없을 것 같은데.
    public LottoGame(int totalPayments) {
        this.payments = new Payments(totalPayments);
        this.tickets = new LottoTickets(initAutoTickets(payments.ticketCount()));
    }

    public LottoGame(int totalPayments, List<List<Integer>> manualLottoTickets) {
        this.payments = new Payments(totalPayments);
        List<LottoTicket> autos = initAutoTickets(payments.ticketCount() - manualLottoTickets.size());

        List<LottoTicket> manuals = initManualTicket(manualLottoTickets);
        List<LottoTicket> combined = initLottoTickets(autos, manuals);

        this.tickets = new LottoTickets(combined);
    }

    public LottoGame(int totalPayments, int[][] manualTicketNumbers) {
        this.payments = new Payments(totalPayments);
        List<LottoTicket> autos = initAutoTickets(payments.ticketCount() - manualTicketNumbers.length);

        List<List<Integer>> manualList = Arrays.stream(manualTicketNumbers)
                .map(x -> Arrays.stream(x).boxed().collect(Collectors.toList()))
                .collect(Collectors.toList());

        List<LottoTicket> manuals = initManualTicket(manualList);
        List<LottoTicket> combined = initLottoTickets(autos, manuals);

        this.tickets = new LottoTickets(combined);
    }

    private List<LottoTicket> initLottoTickets(List<LottoTicket> autos, List<LottoTicket> manuals) {
        List<LottoTicket> combined = new ArrayList<>();
        combined.addAll(autos);
        combined.addAll(manuals);
        return combined;
    }

    private List<LottoTicket> initManualTicket(List<List<Integer>> manualLottoTickets) {
        return manualLottoTickets.stream()
                .map(LottoTicket::valueOf)
                .collect
                        (Collectors.toList());
    }

    private List<LottoTicket> initAutoTickets(int autoTicketCounts) {
        return IntStream.range(0, autoTicketCounts)
                .mapToObj(i -> new LottoTicket(new RandomNumbers().lottoNumbers()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> lottoTickets() {
        return this.tickets.value();
    }

    public Payments payments() {
        return this.payments;
    }
}
