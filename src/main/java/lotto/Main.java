package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRewards;
import lotto.view.InputView;
import lotto.view.ResultView;

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

        LottoRewards lottoRewards = Lotto.reward(lottoNumbersSet, winningLottoNumbers);
        double totalProfitRate = Lotto.totalProfitRate(lottoNumbersSet, winningLottoNumbers);
        ResultView.printWinningStatics(lottoRewards, totalProfitRate);

        inputView.close();
    }
}
