package lotto.view;

import java.text.MessageFormat;
import lotto.domain.Lottos;

public class ResultView {

    public void printLottos(Lottos lottos) {
        printPurchaseQuantity(lottos);
        printEachLotto(lottos);
    }

    private void printPurchaseQuantity(Lottos lottos) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottos.getCount()));
    }

    private void printEachLotto(Lottos lottos) {
        lottos.getLottos()
            .forEach(lotto -> System.out.println("[" + lotto + "]"));
    }
}
