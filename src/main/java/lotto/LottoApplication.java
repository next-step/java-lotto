package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askBuyAmount();

        Scanner sc = new Scanner(System.in);
        Amount lottoAmount = new Amount(sc.nextLong());
        int lottoPieceCount = lottoAmount.lottoPieceCount();

        resultView.printLottoCount(lottoPieceCount);

        Lotto lotto = new LottoMachine().lotto(lottoPieceCount);
        resultView.printLotto(lotto);

        inputView.askMatchingNumber();
        WinningNumbers winningNumbers = new WinningNumbers(sc.next());

        MatchingMachine matchingMachine = new MatchingMachine(lotto, winningNumbers);
        matchingMachine.match();

        resultView.printMatchingStatistics(matchingMachine.matchCriterias(), matchingMachine.rate(lottoAmount));
    }
}
