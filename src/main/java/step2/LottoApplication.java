package step2;

import java.util.*;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Lotto lotto = new Lotto();

        int lottoCount = inputView.inputCash();
        resultView.countLottoResult(lottoCount);
        List<Integer> standardLotto = lotto.generateStandardLotto();

        Set<List<Integer>> purchasedLottos = lotto.purchasedLottos(standardLotto, lottoCount);
        resultView.printPurchasedLottos(purchasedLottos);

        String[] inputWinningNumbers = inputView.inputWinningNumbers();  // 공백 제거하지 않은 상테
    }


}