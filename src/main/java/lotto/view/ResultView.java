package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.List;

public class ResultView {

    private static final String OUTPUT_BUY_LOTTO_COUNT = "%d개를 구매했습니다.\n";

    private ResultView() {}

    public static void printLottoResult(Lottos lottos) {
        printBuyLottoCount(lottos);
        lottoResult(lottos.getLottos());
        System.out.println();
    }

    private static void printBuyLottoCount(Lottos lottos) {
        System.out.printf(OUTPUT_BUY_LOTTO_COUNT,lottos.getLottos().size());
    }

    private static void lottoResult(List<Lotto> lottoList) {
        lottoList.forEach(ResultView::printLotto);
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(Arrays.toString(lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber).sorted().toArray()));
    }
}
