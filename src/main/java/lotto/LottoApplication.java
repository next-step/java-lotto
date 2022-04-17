package lotto;

import lotto.util.LottoGenerator;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int insertLottoPrice = inputView.insertLottoPrice();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> lotteries = lottoGenerator.generate(insertLottoPrice);

        resultView.printPurchaseLottoList(lotteries);

        List<Integer> winningLotto = inputView.insertWinningLotto();

        LottoMachine lottoMachine = new LottoMachine();
        List<Statistic> statistics = lottoMachine.findBoughtLottoStatistics(winningLotto, lotteries);

        resultView.printLottoStatistic(statistics);

        double rate = Statistic.calculateRate(insertLottoPrice, statistics);
        resultView.printTotalRate(rate);
    }
}
