package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketBundle {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketBundle(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTicketBundle(LottoTicketBundle manualLottoTickets, LottoTicketBundle autoLottoTickets) {
        this(Stream.concat(manualLottoTickets.getLottoTickets().stream(), autoLottoTickets.getLottoTickets().stream())
                .collect(Collectors.toList()));
    }

    public static LottoTicketBundle create(int payAmount) {
        int ticketCount = payAmount / LottoTicket.LOTTO_TICKET_PRICE;
        return new LottoTicketBundle(
                IntStream.range(0, ticketCount)
                .mapToObj(i -> new LottoTicket(generateRandomNumbers()))
                .collect(Collectors.toList())
        );
    }

    private static List<Integer> generateRandomNumbers() {
        return IntStream.rangeClosed(LottoNumber.LOTTO_NUBER_MIN, LottoNumber.LOTTO_NUBER_MAX)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.shuffle(list, new Random());
                            return list.stream().limit(LottoTicket.LOTTO_NUBERS_SIZE).collect(Collectors.toList());
                        }));
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
