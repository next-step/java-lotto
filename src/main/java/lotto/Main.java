package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        ResultView.printPurchasePriceInputCommand();
        long purchasePrice = Long.parseLong(inputView.nextLine());
        long lottoCount = Lotto.lottoCount(purchasePrice);
        ResultView.printLottoCount(lottoCount);

        List<LottoNumbers> lottoNumbersList = Lotto.generateAllLottoNumbers(lottoCount);
        ResultView.printAllLottoNumbers(lottoNumbersList);

        ResultView.printWinningLottoNumberInputCommand();
        LottoNumbers winningLottoNumbers = Lotto.winningLottoNumbers(inputView.nextLine());

        Map<Integer, Integer> matchCounts = Lotto.matchCounts(lottoNumbersList, winningLottoNumbers);
        double totalProfitRate = Lotto.totalProfitRate(lottoNumbersList, winningLottoNumbers);


        inputView.close();
    }
}
