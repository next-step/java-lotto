package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.strategy.LottoGenerator;
import lotto.strategy.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {

    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();
    private static LottoGenerator lottoRandomGenerator = new LottoRandomGenerator();

    public static void main(String[] args) {
        int purchasePrice = inputView.askPurchasePrice();
        List<Lotto> purchasedLottoList = buyLotto(purchasePrice);
        Lotto winningLotto = EnterWinningNumber();

        checkWinningStatistics(purchasePrice, purchasedLottoList, winningLotto);
    }

    private static List<Lotto> buyLotto(int purchasePrice) {
        int lottoCount = purchasePrice / 1000;
        ResultView.printPurchaseInfo(lottoCount);

        List<Lotto> lottoList = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottoList.add(new Lotto(lottoRandomGenerator));
        }
        resultView.printLottoNumbers(lottoList);

        return lottoList;
    }

    private static Lotto EnterWinningNumber() {
        List<Integer> winningNumbers = inputView.askLottoWinningNumbers();
        return new Lotto(winningNumbers);
    }

    private static void checkWinningStatistics(int purchasePrice, List<Lotto> lottoList, Lotto winningLotto) {
        Map<LottoResult, Integer> lottoResults = Arrays.stream(LottoResult.values())
                .collect(Collectors.toMap(k -> k, v -> 0, (x, y) -> y, LinkedHashMap::new));

        for (Lotto lotto : lottoList) {
            LottoResult lottoResult = lotto.match(winningLotto);
            lottoResults.put(lottoResult, lottoResults.getOrDefault(lottoResult, 0) + 1);
        }

        resultView.printWinningStatistics(purchasePrice, lottoResults);
    }

}
