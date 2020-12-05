package lotto.domain;

import java.util.Set;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    private Lottos lottos;

    public LottoShop() {
        this.lottos = new Lottos();
    }

    public LottoTicket purchaseLottoTicket(Money money) {
        return new LottoTicket(money.getPurchasePrice() / LOTTO_PRICE);
    }

    public Lottos exchangeManualLottos(LottoTicket ticket, Set<Integer> lottoNumbers) {
        lottos.addLotto(Lotto.of(lottoNumbers));
        ticket.spend();
        return lottos;
    }

    public Lottos exchangeAutoLottos(LottoTicket ticket, LottoMachine lottoMachine) {
        int remainCount = ticket.getRemainCount();
        for (int i = 0; i < remainCount; i++) {
            lottos.addLotto(Lotto.createLottoNumber(lottoMachine));
        }
        return lottos;
    }

}