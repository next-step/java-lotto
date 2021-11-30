package lotto.view;


import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ResultView {

    private ResultView() {
    }

    public static void printView(String str) {
        System.out.println(str);
    }

    public static void printLottoNumberView(Lottos lottos) {
        lottos.getLottos().forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }


}
