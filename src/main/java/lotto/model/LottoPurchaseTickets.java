package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPurchaseTickets {
    private List<LottoPurchaseTicket> lottoTickets;

    private LottoPurchaseTickets(List<LottoPurchaseTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoPurchaseTickets create(List<LottoPurchaseTicket> lottoTickets) {
        if(Objects.isNull(lottoTickets) || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("lotto tickets is null or empty");
        }

        return new LottoPurchaseTickets(lottoTickets);
    }

    public LottoResults checkAll(WinningLottoTicket winningLottoTicket) {
        List<LottoResult> lottoResults = lottoTickets.stream()
                .map(ticket -> ticket.check(winningLottoTicket))
                .collect(Collectors.toList());

        return LottoResults.create(lottoResults);
    }
}
