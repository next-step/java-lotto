package lotto;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        int money = new InputView().getMoneyInput();

        List<Lotto> lottos = lottoFactory.issueTicketsByMoney(money);

        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottos);
        resultView.printLottos(lottos);

        Lotto winningLotto = lottoFactory.createLotto(new InputView().getWinningLottoInput());
        resultView.printWinningResult(lottoFactory.getRankResults(winningLotto, lottos));
        resultView.printRateOfReturn(lottoFactory.calculateRateOfReturn(winningLotto, lottos));
    }
}
