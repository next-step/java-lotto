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
        List<Rank> ranks = lottoMachine.findBoughtLottoRank(winningLotto, lotteries);

        resultView.printLottoRank(ranks);

        double rate = Rank.calculateRate(insertLottoPrice, ranks);
        resultView.printTotalRate(rate);
    }
}
