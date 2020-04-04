package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class PurchaseLottoView {

    public void print(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개 를 구매 했다");
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
