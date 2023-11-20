package step2.lotto.view;

import step2.lotto.domain.LottoPurchaseInfo;
import step2.lotto.domain.Lottos;

public class ResultView {

    private static final String PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";

    public void printPurchaseResultMessage(final LottoPurchaseInfo purchaseInfo) {
        System.out.printf(PURCHASE_RESULT_MESSAGE, purchaseInfo.getLottoTicketCount());
    }

    public void printPurchaseLottoTicketNumbers(final Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.toString()));
    }
}
