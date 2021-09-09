package step2.view;

import step2.domain.lotto.LottoMachine;
import step2.domain.lotto.Lottos;
import step2.domain.statistics.Statistics;

public class OutputView {

    public void printLottoPurchase(LottoMachine lottoMachine, Lottos issueLottos) {
        System.out.println();
        System.out.println(lottoMachine);
        System.out.println(issueLottos);
    }

    public void printResult(Statistics statistics) {
        System.out.println();
        System.out.println(statistics);
        System.out.println(statistics.profitRate());
    }
}
