package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;

public class OutputView {

    private static final String LOTTO_COUNT_OUTPUT_MESSAGE = "개를 구매했습니다.";

    private OutputView() {}

    public static void lottoCountOutput(Lottos lottos) {
        System.out.println(lottos.getLottoCount() + LOTTO_COUNT_OUTPUT_MESSAGE);
    }

    public static void lottoDetailOutput(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }
}
