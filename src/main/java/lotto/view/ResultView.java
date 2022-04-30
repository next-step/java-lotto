package lotto.view;

import lotto.domain.Lottos;
import lotto.exception.NotSupportInstanceException;

public class ResultView {

    private static final String MESSAGE_PURCHASED_LOTTO = "개를 구매했습니다.";

    private ResultView() {
        throw new NotSupportInstanceException();
    }

    public static void purchasedLottosView(Lottos lottos) {
        System.out.println(lottos.count() + MESSAGE_PURCHASED_LOTTO);
        System.out.println(ResultBuilder.buildLottosInfo(lottos.toList()));
    }
}
