package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningCheck;
import lotto.domain.WinningNumber;
import lotto.service.LottoPurchaseService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        WinningNumber winningNumber = new WinningNumber();

        Lottos lottos = new Lottos();
        lottos.buyLotto(lottoPurchaseService.calculateNumberOfLotto(inputView.inputPurchaseAmountGuide(sc))
                ,LottoShuffleGenerator.getLottoShuffleGenerator());
        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);
        sc.nextLine();
        winningNumber.convertStringToIntList(inputView.inputWinnerNumber(sc));
        WinningCheck winningCheck = new WinningCheck(lottos,winningNumber);
        System.out.println(winningCheck.getWinningPrize());
    }
}
