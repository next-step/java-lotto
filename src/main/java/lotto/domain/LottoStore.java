package lotto.domain;

import java.math.BigDecimal;

public class LottoStore {
    public static Lottos sold(BigDecimal price){
        Lottos lottos = new Lottos();
        int amount = price.divide(Lotto.PRICE).intValue();

        for(int i = 0 ; i < amount ; i ++){
            lottos.add(LottoFactory.create());
        }

        return lottos;
    }

    public static Winners getWinner(Lottos lottos, String[] winningNumbers, int bonumsNumber){
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonumsNumber);
        return lottos.getWinner(winningLotto);
    }
}