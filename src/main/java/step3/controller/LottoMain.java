package step3.controller;

import step3.domain.lotto.LottoGame;
import step3.domain.lotto.LottoResult;
import step3.domain.lotto.LottoTicket;

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
        LottoTicket userLottoTicket = lottoGame.createUserLottoTicket(totalCount);
        Set<Integer> winningLottoNumbers = winningNumbers();
        LottoTicket winningLottoTicket = lottoGame.createWinningLottoTicket(winningLottoNumbers);
        int bonusNumber = bonusNumber(winningLottoNumbers);

        LottoResult lottoResult = lottoGame.playLottoGame(userLottoTicket, winningLottoTicket, bonusNumber);
        result(purchaseAmount, lottoResult);
    }
}
