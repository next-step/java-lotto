package lotto.domain;

import java.util.*;

/**
 * 역할: 내가 산 로또 생성 및 보관
 */
public class MyLottoTickets {

    private final LottoPrice lottoPrice;
    private final List<LottoTicket> lottoTickets;

    public MyLottoTickets(LottoPrice lottoPrice) {
        this(lottoPrice, new ArrayList<>());
    }

    public MyLottoTickets(LottoPrice lottoPrice, List<LottoTicket> lottoTickets) {
        this.lottoPrice = lottoPrice;
        this.lottoTickets = lottoTickets;
    }

    public void buy() {
        int numberOfTicket = numberOfTicket();
        for (int i = 0; i < numberOfTicket; i++) {
            lottoTickets.add(LottoTicket.randomLottoTicket());
        }
    }

    public int totalTicketPurchasePrice() {
        return lottoPrice.realPurchaseAmount();
    }

    public int numberOfTicket() {
        return lottoPrice.numberOfTicket();
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
