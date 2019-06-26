package lotto.model;

import lotto.model.generator.*;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public LottoTicket buy(PurchaseRequest purchaseRequest) {
        List<Lotto> lottos = new ArrayList<>();
        if (purchaseRequest.hasManualLotto()) {
            lottos.addAll(buyManualLotto(purchaseRequest));
        }
        if (purchaseRequest.hasRandomLotto()) {
            lottos.addAll(buyRandomLotto(purchaseRequest));
        }
        return LottoTicket.of(lottos);
    }

    List<Lotto> buyManualLotto(PurchaseRequest purchaseRequest) {
        LottoGenerator lottoGenerator = new ManualGenerator(purchaseRequest.getManualLottoInfo());
        return lottoGenerator.generator();
    }

    public List<Lotto> buyRandomLotto(PurchaseRequest purchaseRequest) {
        LottoGenerator lottoGenerator = new RandomLottoGenerator(purchaseRequest.getMoney());
        return lottoGenerator.generator();
    }
}
