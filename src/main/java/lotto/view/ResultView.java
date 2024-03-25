package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    public static void printBuyLotto(Lottos lottos){
        System.out.println(lottos.lottos().size() + "개를 구매했습니다.");
        for(Lotto lotto : lottos.lottos()){
            System.out.println(lotto.lotto());
        }
    }

}
