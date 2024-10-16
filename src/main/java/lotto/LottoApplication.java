package lotto;

import static lotto.view.InputView.inputInt;
import static lotto.view.InputView.inputLotto;
import static lotto.view.ResultView.printLottoGames;
import static lotto.view.ResultView.printRatio;
import static lotto.view.ResultView.printResults;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoPrice;
import lotto.domain.LottoResults;
import lotto.domain.WinningLotto;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = makeLottoGame();
        printLottoGames(lottoGame);

        WinningLotto winningLotto = new WinningLotto(new Lotto(inputLotto(ResultView::printLastWeekLotto)),
                inputInt(ResultView::printInputBonusNumber));
        LottoResults lottoResults = lottoGame.makeLottoResult(winningLotto);

        printResults(lottoResults);
        printRatio(lottoGame.getEarnRate());
    }

    public static LottoGame makeLottoGame() {
        LottoPrice lottoPrice = new LottoPrice(inputInt(ResultView::printInputPrice));
        LottoCount lottoCount = new LottoCount(lottoPrice, inputInt(ResultView::printManualLottoCount));

        if (lottoCount.getManualCount() > 0) {
            List<Lotto> manualLottoList = makeManualLotto(lottoCount);
            return new LottoGame(lottoPrice, lottoCount, manualLottoList);
        }

        return new LottoGame(lottoPrice);
    }

    public static List<Lotto> makeManualLotto(LottoCount lottoCount) {
        List<Lotto> manualLottoList = new ArrayList<>();
        manualLottoList.add(new Lotto(inputLotto(ResultView::printManualLottoInput)));

        for (int i = 1; i < lottoCount.getManualCount(); i++) {
            manualLottoList.add(new Lotto(inputLotto(null)));
        }
        return manualLottoList;
    }
}
