package lotto;

import java.util.List;

public class OutputView {

    static void printPurchaseLottoNumber(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

}
