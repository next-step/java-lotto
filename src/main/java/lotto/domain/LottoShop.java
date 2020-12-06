package lotto.domain;

import java.util.List;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;
    private LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTicket purchaseTicket(Money money, int manualLottoQuantity) {
        return LottoTicket.of(money.getPurchasePrice() / LOTTO_PRICE, manualLottoQuantity);
    }

    public Lottos purchaseLottos(LottoTicket ticket, List<Lotto> manualLottos) {
        Lottos lottos = new Lottos();
        lottos.addAllLottos(manualLottos);
        for (int i = 0; i < ticket.getAutoQuantity(); i++) {
            lottos.addLotto(Lotto.createLottoNumber(lottoMachine));
        }
        return lottos;
    }

}