package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String PURCHASE_MESSAGE = "%s 개를 구매했습니다.\n";
    public static void printLottosCount(Lottos lottos) {
        int lottoCount = lottos.lottoCount();
        System.out.printf(PURCHASE_MESSAGE, lottoCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        String collect = lotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println(collect);
    }

}
