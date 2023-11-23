package step3.controller;

import step3.domain.lotto.LottoGame;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoResult;
import step3.view.OutputView;

import java.util.List;
import java.util.Set;

import static step3.view.InputView.bonusNumber;
import static step3.view.InputView.purchaseAmount;
import static step3.view.InputView.totalCount;
import static step3.view.InputView.winningNumbers;
import static step3.view.OutputView.result;

public class LottoMain {

    public static void main(String[] args) {
        int purchaseAmount = purchaseAmount();
        int totalCount = totalCount(purchaseAmount);

        LottoGame lottoGame = new LottoGame();
        List<LottoNumber> userLottoNumbers = lottoGame.createUserLottoNumbers(totalCount);
        userLottoNumbers.stream().forEach(OutputView::printLottoNumbers);

        Set<Integer> winningNumbers = winningNumbers();
        LottoNumber winningLottoNumber = lottoGame.createWinningLottoNumber(winningNumbers);
        int bonusNumber = bonusNumber(winningNumbers);

        LottoResult lottoResult = lottoGame.playLottoGame(userLottoNumbers, winningLottoNumber, bonusNumber);
        result(purchaseAmount, lottoResult);
    }
}
