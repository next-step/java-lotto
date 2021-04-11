package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        List<Lotto> manualLottos = getManualLottos();
        Lottos lottos = new Lottos(purchaseAmount, manualLottos);

        ResultView.printPurchaseLotto(lottos, manualLottos);

        WinningNumber winningNumber = getWinningNumber();

        Statistics statistics = new Statistics(lottos.winningResults(winningNumber));

        ResultView.printStatistics(statistics);
        ResultView.printYield(statistics, purchaseAmount);
    }

    private static WinningNumber getWinningNumber() {
        String inputWinningNumber = InputView.getWinningNumber();
        String inputBonusNumber = InputView.getBonusNumber();

        WinningNumber winningNumber = new WinningNumber(Parser.parse(Split.splitDelimiter(inputWinningNumber))
                , Integer.parseInt(inputBonusNumber));
        return winningNumber;
    }

    private static List<Lotto> getManualLottos() {
        int manualLottoNum = InputView.getManualLotto();
        List<Lotto> manualLottos = new ArrayList<>();
        InputView.printManualLottoNumbers();
        for (int i = 0; i < manualLottoNum; i++) {
            String inputManualLottoNumber = InputView.getManualLottoNumbers();
            Lotto manualLotto = new Lotto(Parser.parse(Split.splitDelimiter(inputManualLottoNumber)));
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }
}
