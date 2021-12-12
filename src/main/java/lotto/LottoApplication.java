package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askBuyAmount();

        Scanner sc = new Scanner(System.in);
        int lottoPieceCount = new Amount(sc.nextInt()).lottoPieceCount();

        resultView.printLottoCount(lottoPieceCount);

        Lotto lotto = new LottoMachine().lotto(lottoPieceCount);
        resultView.printLotto(lotto);

        inputView.askMatchingNumber();


    }
}
