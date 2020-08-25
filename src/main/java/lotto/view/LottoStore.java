package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;

public class LottoStore {
    public Lottos sold(int price){
        Lottos lottos = new Lottos();
        int amount = price / Lotto.PRICE;
        for(int i = 0 ; i < amount ; i ++){
            lottos.add(LottoFactory.create());
        }

        System.out.println(amount+"개를 구매 했습니다.");
        System.out.println(lottos.toString());

        return lottos;
    }
}