package step2;

import step2.domain.LottoGame;
import step2.domain.LottoResult;
import step2.view.InputView;
import step2.view.PrintView;

import java.util.List;

public class Lotto {

    public static void main(String[] args) {

        int purchaseAmount = InputView.purchaseAmount();
        LottoGame lottoGame = LottoGame.readyGame(purchaseAmount);

        List<List<Integer>> purchaseNumber = lottoGame.generateNumber();
        PrintView.purchaseNumber(purchaseNumber);

        List<Integer> winningNumber = InputView.winningNumber();
        LottoResult result  = lottoGame.countNumber(purchaseNumber, winningNumber);
        PrintView.lottoResult(result);
    }
}
