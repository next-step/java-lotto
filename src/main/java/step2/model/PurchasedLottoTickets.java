package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PurchasedLottoTickets {

    private List<PurchasedLottoTicket> purchasedLottoTickets;

    public PurchasedLottoTickets(List<PurchasedLottoTicket> purchasedLottoTickets) {
        this.purchasedLottoTickets = new ArrayList<>(purchasedLottoTickets);
    }

    public static PurchasedLottoTickets create(List<PurchasedLottoTicket> purchasedLottoTickets) {
        return new PurchasedLottoTickets(purchasedLottoTickets);
    }

    public int size() {
        return purchasedLottoTickets.size();
    }

    public List<PurchasedLottoTicket> getPurchasedLottoTickets() {
        return purchasedLottoTickets;
    }

    public LottoResults match(WinningLottoTicket winningLottoTicket) {
        List<LottoResult> lottoResults = purchasedLottoTickets.stream()
            .map(ticket -> ticket.match(winningLottoTicket))
            .collect(Collectors.toList());

        return LottoResults.of(lottoResults);
    }
}
