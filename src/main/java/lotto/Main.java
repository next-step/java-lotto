package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        long purchasePrice = inputView.inputPurchasePrice();
        long lottoCount = Lotto.lottoCount(purchasePrice);
        ResultView.printLottoCount(lottoCount);

        Set<LottoNumbers> lottoNumbersSet = Lotto.generateAllLottoNumbers(lottoCount);

        ResultView.printAllLottoNumbers(lottoNumbersSet);

        LottoNumbers winningLottoNumbers = Lotto.winningLottoNumbers(inputView.inputWinningLottoNumbers());

        Map<Integer, Integer> matchCounts = Lotto.matchCounts(lottoNumbersSet, winningLottoNumbers);
        double totalProfitRate = Lotto.totalProfitRate(lottoNumbersSet, winningLottoNumbers);
        ResultView.printWinningStatics(matchCounts, totalProfitRate);

        inputView.close();
    }
}
