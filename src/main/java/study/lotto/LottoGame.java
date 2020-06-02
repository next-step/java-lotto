package study.lotto;

import study.lotto.model.LottoList;
import study.lotto.model.Statistics;
import study.lotto.model.WinningLotto;
import study.lotto.view.InputView;
import study.lotto.view.ResultView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public void play() {
        int totalPrice = InputView.scanTotalPrice();
        int numOfLotto = totalPrice / LOTTO_PRICE;

        LottoList lottoList = LottoList.create(numOfLotto);

        ResultView.printPurchaseMessage(numOfLotto);
        ResultView.printLottoList(lottoList);
        ResultView.printEmptyLine();

        WinningLotto winningLotto = WinningLotto.convertToWinningLotto(InputView.scanWinningNumbers());

        Statistics statistics = new Statistics(lottoList);
        statistics.calculateStatistics(winningLotto);

        ResultView.printEmptyLine();
        ResultView.printStatistics(statistics);
        ResultView.printEarningRate(statistics.calculateEarningRate(totalPrice));
    }

    public static void main(String[] args) {
        new LottoGame().play();
    }
}
