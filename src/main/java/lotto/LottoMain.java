package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import static lotto.domain.Lotto.LOTTO_PRICE;
import lotto.domain.result.LottoGameResult;
import lotto.domain.Lottos;
import lotto.domain.Winner;
import lotto.ui.InputView;
import lotto.ui.LottoScanner;
import lotto.ui.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = LottoScanner.insertPurchaseAmount();

        int manualLottoCount = LottoScanner.insertManualLottoCount();

        if (manualLottoCount > purchaseAmount / LOTTO_PRICE) {
            System.out.println("입력 가능한 최대 수동 로또의 수는 " + purchaseAmount / LOTTO_PRICE + "입니다.");
            return;
        }

        if (manualLottoCount > 0) {
            InputView.printInsertLottoPharse();
        }

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; ++i) {
            String input = LottoScanner.insertLotto();
            manualLottos.add(Lotto.of(input));
        }

        Lottos lottos = Lottos.of(purchaseAmount, manualLottos);
        ResultView.printLottos(lottos, manualLottoCount);

        String winningNumbers = LottoScanner.insertWinningNumbers();
        int bonusNumber = LottoScanner.insertBonusNumber();

        Winner winner;
        try {
            winner = Winner.of(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return;
        }

        LottoGameResult lottoGameResult = winner.findWinners(lottos);
        ResultView.printLottoGameResult(lottoGameResult);
    }
}
