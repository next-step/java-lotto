package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class ResultView {
    private static final String PRINT_PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public ResultView() {
    }

    public static void printPurchaseLottoCount(final Lottos lottos) {
        System.out.println(lottos.getLottos().size() + PRINT_PURCHASE_LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .collect(Collectors.toList()));
        }
        System.out.println();
    }
}
