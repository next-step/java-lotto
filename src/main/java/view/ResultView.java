package view;

import domain.Lotto;
import domain.Lottos;

public class ResultView {
    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream()
                .forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }
}
