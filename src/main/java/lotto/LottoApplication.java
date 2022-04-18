package lotto;

import lotto.util.LottoGenerator;
import lotto.util.StatisticCalculator;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int insertLottoPrice = inputView.insertLottoPrice();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lotteries = lottoGenerator.generate(insertLottoPrice);

        resultView.printPurchaseLottoList(lotteries);

        List<Integer> winningLotto = inputView.insertWinningLotto();

        List<Rank> ranks = LottoMachine.findBoughtLottoRank(winningLotto, lotteries);

        resultView.printLottoRank(ranks);

        double rate = StatisticCalculator.calculateRate(insertLottoPrice, ranks);
        resultView.printTotalRate(rate);
    }
}
