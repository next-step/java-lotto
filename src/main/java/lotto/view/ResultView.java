package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    public static void printResult(Lottos lottos){

        for(Lotto lotto : lottos.lottos()){
            System.out.println(lotto.lotto());
        }
    }
}
