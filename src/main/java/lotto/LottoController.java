package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int purchasePrice = inputView.askPurchasePrice();
        Lotto[] purchasedLottoList = buyLotto(purchasePrice);
        Lotto winningLotto = EnterWinningNumber();

        checkWinningStatistics(purchasePrice, purchasedLottoList, winningLotto);
    }

    private static Lotto[] buyLotto(int purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        ResultView.printPurchaseInfo(lottoCount);

        Lotto[] lottoList = new Lotto[lottoCount];
        for (int index = 0; index < lottoCount; index++) {
            lottoList[index] = new Lotto();
        }
        resultView.printLottoNumbers(lottoList);

        return lottoList;
    }

    private static Lotto EnterWinningNumber() {
        List<Integer> winningNumbers = inputView.askLottoWinningNumbers();
        Lotto winningLotto = new Lotto(winningNumbers);
        return winningLotto;
    }

    private static void checkWinningStatistics(int purchasePrice, Lotto[] lottoList, Lotto winningLotto) {
        Map<LottoResult, Integer> lottoResults = Arrays.stream(LottoResult.values())
                .collect(Collectors.toMap(k -> k, v -> 0, (x, y) -> y, LinkedHashMap::new));

        for (Lotto lotto : lottoList) {
            LottoResult lottoResult = lotto.match(winningLotto);
            lottoResults.put(lottoResult, lottoResults.getOrDefault(lottoResult, 0) + 1);
        }

        resultView.printWinningStatistics(purchasePrice, lottoResults);
    }

}
