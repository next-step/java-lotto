package step2;

import step2.service.LottoGame;
import step2.domain.LottoResult;
import step2.view.InputView;
import step2.view.PrintView;

import java.util.List;

public class Lotto {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        LottoGame lottoGame = LottoGame.readyGame(purchaseAmount);

        List<List<Integer>> purchaseNumber = lottoGame.generateLotto();
        PrintView.purchaseNumber(purchaseNumber);

        List<Integer> winningNumber = InputView.winningNumber();
        LottoResult result  = lottoGame.lottoResult(purchaseNumber, winningNumber);
        PrintView.lottoResult(result);
    }
}
