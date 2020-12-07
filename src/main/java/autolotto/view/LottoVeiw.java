package autolotto.view;

import autolotto.model.Lotto;
import autolotto.model.Lottos;

import java.util.List;

public class LottoVeiw {

    public static void viewLottos(Lottos lottos){
        System.out.println(lottos.getLottosCount() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getLottosCount(); i++) {
            viewLotto(lottos.getLotto(i));
        }
    }

    private static void viewLotto(Lotto lotto){
        System.out.println(lotto.getNumberList());
    }
}
