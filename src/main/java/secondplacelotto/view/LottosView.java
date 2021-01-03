package secondplacelotto.view;

import secondplacelotto.model.Lotto;
import secondplacelotto.model.Lottos;

public class LottosView {

    public static void viewLottos(Lottos lottos) {
        System.out.println(lottos.getLottosCount() + "개를 구매했습니다.");

        for (int i = 0; i < lottos.getLottosCount(); i++) {
            viewLotto(lottos.getLotto(i));
        }
    }

    private static void viewLotto(Lotto lotto){
        System.out.println(lotto.getNumberList());
    }
}
