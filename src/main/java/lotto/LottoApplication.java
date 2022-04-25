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
        int directlyBoughtCount = inputView.insertDirectlyBoughtCount();

        List<String[]> directlyUserLottoStringList = inputView.insertDirectlyBoughtLottoList(directlyBoughtCount);

        List<Lotto> directlyUserLottoList = lottoGenerator.generateDirectlyLotto(directlyUserLottoStringList);
        List<Lotto> autoUserLottoList = lottoGenerator.generateLotteries(purchasePrice, directlyBoughtCount);

        resultView.printBoughtLottoList(directlyUserLottoList, autoUserLottoList);
        directlyUserLottoList.addAll(autoUserLottoList);

        Lotto winningLotto = inputView.insertWinningLotto();
        LottoNumber bonusLottoNumber = new LottoNumber(inputView.insertBonusNumber());

        List<Rank> directlyLottoRank = LottoMachine.findUserLottoRanks(directlyUserLottoList, winningLotto, bonusLottoNumber);

        resultView.printTotalRanks(directlyLottoRank);

        double totalRate = StatisticCalculator.calculateRate(purchasePrice, directlyLottoRank);
        resultView.printTotalRate(totalRate);
    }
}
