package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottoTickets {

    private List<PurchasedLottoTicket> purchasedLottoTickets;

    public PurchasedLottoTickets(List<PurchasedLottoTicket> purchasedLottoTickets) {
        this.purchasedLottoTickets = new ArrayList<>(purchasedLottoTickets);
    }

    public static PurchasedLottoTickets create(List<PurchasedLottoTicket> purchasedLottoTickets) {
        return new PurchasedLottoTickets(purchasedLottoTickets);
    }

    public PurchasedLottoTickets merged(PurchasedLottoTickets tickets) {
        List<PurchasedLottoTicket> mergeTickets = new ArrayList<>(purchasedLottoTickets);
        mergeTickets.addAll(tickets.purchasedLottoTickets);

        return PurchasedLottoTickets.create(mergeTickets);
    }

    public int count() {
        return purchasedLottoTickets.size();
    }

    public List<PurchasedLottoTicket> getPurchasedLottoTickets() {
        return purchasedLottoTickets;
    }
}
