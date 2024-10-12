package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.getLottoCount() + LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .collect(Collectors.toList()));
        }
    }
}
