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
        ticket.spend();
        return lottos;
    }

    public Lottos exchangeAutoLottos(LottoMachine lottoMachine) {
        int remainCount = ticket.getRemainCount();
        for (int i = 0; i < remainCount; i++) {
            lottos.addLotto(Lotto.createLottoNumber(lottoMachine));
        }
        return lottos;
    }

    public int remainTicketCount() {
        return ticket.getRemainCount();
    }

    public LottoTicket getLottoTicket(){
        return ticket;
    }
}