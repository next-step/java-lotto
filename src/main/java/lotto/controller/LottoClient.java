package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.view.OutputView.*;
import static lotto.view.ViewUtil.*;

public class LottoClient {

    public static void main(String[] args) {
        Cash cash = insertCash();
        ManualLottoCount manualLottoCount = insertManualLottoCount(cash);
        Lottos lottos = generateManualLottos(manualLottoCount);
        generateLottos(lottos, manualLottoCount.getLeftOvers(cash));
        printCount(manualLottoCount.getCount(), manualLottoCount.getLeftOvers(cash));
        printLottoGroup(lottos);
        WinningLotto winningLotto = insertWinningNumbers();
        Match match = new Match();
        lottos.saveMatchResult(winningLotto, match);
        printResult(cash, match);
    }

    private static WinningLotto insertWinningNumbers() {
        List<LottoNumber> latestWinningNumbers = insertLatestWinningNumbers();
        int bonusNumber = insertBonusNumber();
        return new WinningLotto(latestWinningNumbers, bonusNumber);
    }

    private static void generateLottos(Lottos lottos, int amount) {
        lottos.generateLottoNumbers(new LottoGenerator(), amount);
    }
}
