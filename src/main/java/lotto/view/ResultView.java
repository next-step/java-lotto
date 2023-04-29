package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.WinnerLotto;

import java.util.List;

public class ResultView {

    public static void autoLottoPrint(List<Lotto> lottoList) {
        System.out.println();

        lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printLottoStatistics(List<Lotto> lottos, WinnerLotto winnerLotto) {
        LottoStatistics lottoStatistics = new LottoStatistics(winnerLotto, lottos);
        System.out.println(lottoStatistics.getStatistics());
    }
}
