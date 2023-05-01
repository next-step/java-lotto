package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoRewards;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        long purchasePrice = inputView.inputPurchasePrice();
        long lottoCount = Lotto.lottoCount(purchasePrice);
        ResultView.printLottoCount(lottoCount);

        List<LottoNumbers> lottoNumbersList = Lotto.generateAllLottoNumbers(lottoCount);

        ResultView.printAllLottoNumbers(lottoNumbersList);

        LottoNumbers winningLottoNumbers = Lotto.winningLottoNumbers(inputView.inputWinningLottoNumbers());
        LottoNumber bonusLottoNumber = Lotto.bonusLottoNumber(inputView.inputBonusLottoNumber(winningLottoNumbers));

        LottoRewards lottoRewards = Lotto.reward(lottoNumbersList, winningLottoNumbers);
        ResultView.printWinningStatics(lottoRewards, purchasePrice);

        inputView.close();
    }
}
