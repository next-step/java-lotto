package step3.model;


import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static LottoBundle purchaseLotto(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        while (money.canPurchase()) {
            lottoList.add(Lotto.fromRandom());
            money.purchase();
        }
        return new LottoBundle(lottoList);
    }

    private LottoMachine() {
    }
}
