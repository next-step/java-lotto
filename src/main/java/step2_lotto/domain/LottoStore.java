package step2_lotto.domain;

import step2_lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> buyLottos(int price){

        int quantity = calculateQuantity(price);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity ; i++) {
            lottos.add(LottoFactory.issueLotto());
        }
        return lottos;
    }

    private static int calculateQuantity(int price) {
        return price / 1000;
    }
}
