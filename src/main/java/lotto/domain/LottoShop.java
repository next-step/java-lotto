package lotto.domain;

import java.util.Set;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private LottoTicket ticket;
    private Lottos lottos;

    public LottoShop() {
        this.lottos = new Lottos();
    }

    public LottoTicket purchaseLottoTicket(Money money) {
        this.ticket = new LottoTicket(money.getPurchasePrice() / LOTTO_PRICE);
        return ticket;
    }

    public Lottos exchangeManualLottos(Set<Integer> lottoNumbers) {
        lottos.addLotto(Lotto.of(lottoNumbers));
        ticket.manualSpend();
        return lottos;
    }

    public Lottos exchangeAutoLottos(LottoMachine lottoMachine) {
        int remainCount = ticket.getQuantity();
        for (int i = 0; i < remainCount; i++) {
            lottos.addLotto(Lotto.createLottoNumber(lottoMachine));
            ticket.autoSpend();
        }
        return lottos;
    }

    public int remainTicketCount() {
        return ticket.getQuantity();
    }

    public LottoTicket getLottoTicket(){
        return ticket;
    }
}