package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
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

        Lottos lottos = new Lottos();
        lottos.buyLotto(lottoPurchaseService.calculateNumberOfLotto(inputView.inputPurchaseAmountGuide(sc))
                ,LottoShuffleGenerator.getLottoShuffleGenerator());
        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);
    }
}
