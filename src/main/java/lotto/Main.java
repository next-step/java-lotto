package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        long purchasePrice = inputView.inputPurchasePrice();
        long lottoCount = LottoGame.lottoCount(purchasePrice);

        ResultView.printLottoCount(lottoCount);

        List<LottoNumbers> lottoNumbersList = LottoGame.generateAllLottoNumbers(lottoCount);

        ResultView.printAllLottoNumbers(lottoNumbersList);

        LottoNumbers winningLottoNumbers = LottoGame.winningLottoNumbers(inputView.inputWinningLottoNumbers());
        LottoNumber bonusLottoNumber = LottoGame.bonusLottoNumber(inputView.inputBonusLottoNumber(winningLottoNumbers));

        LottoRewards lottoRewards = LottoGame.reward(lottoNumbersList, winningLottoNumbers(winningLottoNumbers, bonusLottoNumber));
        double totalProfitRate = LottoGame.totalProfitRate(lottoRewards, purchasePrice);

        ResultView.printWinningStatics(lottoRewards, totalProfitRate);

        inputView.close();
    }

    private static WinningLottoNumbers winningLottoNumbers(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        return new WinningLottoNumbers(winningLottoNumbers, bonusLottoNumber);
    }
}
