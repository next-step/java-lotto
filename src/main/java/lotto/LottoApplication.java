package lotto;

import lotto.util.LottoGenerator;
import lotto.util.StatisticCalculator;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoGenerator lottoGenerator = new LottoGenerator();

        int purchasePrice = inputView.insertLottoPrice();
        List<Lotto> generatedUserLottoList = lottoGenerator.generateLotteries(purchasePrice);

        resultView.printBoughtLottoList(generatedUserLottoList);

        Lotto winningLotto = inputView.insertWinningLotto();
        LottoNumber bonusLottoNumber = new LottoNumber(inputView.insertBonusNumber());

        List<Rank> userLottoRanks = LottoMachine.findUserLottoRanks(generatedUserLottoList, winningLotto, bonusLottoNumber);

        resultView.printTotalRanks(userLottoRanks);

        double totalRate = StatisticCalculator.calculateRate(purchasePrice, userLottoRanks);
        resultView.printTotalRate(totalRate);
    }
}
