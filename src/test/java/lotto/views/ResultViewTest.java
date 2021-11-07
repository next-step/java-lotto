package lotto.views;

import lotto.domains.LottoResults;
import lotto.domains.Lottos;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    @Test
    void 생성된_로또_출력() {
        Lottos lottos = new Lottos("14000");
        ResultView.printLottos(lottos);
    }

    @Test
    void 로또개수출력() {
        ResultView.printLottoCount(14);
    }

    @Test
    void 당첨통계출력() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.addWinner(3);
        lottoResults.addWinner(3);
        lottoResults.addWinner(4);
        lottoResults.addWinner(5);

        ResultView.printLottoResult(lottoResults);
    }

    @Test
    void 수익률_손해() {
        ResultView.printProfitRate(0.35);
    }

    @Test
    void 수익률_기준() {
        ResultView.printProfitRate(1.0);
    }

    @Test
    void 수익률_이득() {
        ResultView.printProfitRate(1.5);
    }

}