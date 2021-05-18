package lotto.view;

import lotto.domain.LottoAuto;
import lotto.domain.Lottos;

public class ResultView {

    public void resultBuyPrice(int buyCount) {
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public void resultLottos(Lottos lottos){
        for(LottoAuto lotto : lottos){
            System.out.println(lotto.getlotto());
        }
    }
}
