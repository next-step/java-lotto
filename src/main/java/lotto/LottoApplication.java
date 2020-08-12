package lotto;

import lotto.domain.LottoStore;
import lotto.domain.core.LottoGenerator;
import lotto.domain.core.WinLotto;

import static lotto.domain.core.LottoGenerator.fromIntSet;
import static lotto.ui.LottoDisplay.display;
import static lotto.ui.LottoDisplay.newLine;
import static lotto.ui.LottoUserInput.inputBonusNo;
import static lotto.ui.LottoUserInput.inputPurchaseAmount;
import static lotto.ui.LottoUserInput.inputWinLotto;

public class LottoApplication {
    public static void main(String[] args) {
        final LottoStore lottoStore = LottoStore.purchaseAutoLotto(inputPurchaseAmount());
        displayLottoList(lottoStore);
        displayLottoStatistics(lottoStore);
    }

    private static void displayLottoList(LottoStore lottoStore) {
        newLine();
        display(String.format("%d개를 구매했습니다.", lottoStore.countOfPurchased()));
        display(lottoStore.displayLottoList());
    }

    private static void displayLottoStatistics(LottoStore lottoStore) {
        final WinLotto winLotto = LottoGenerator.winLotto(fromIntSet(inputWinLotto()), inputBonusNo());
        newLine(1);
        display("당첨 통계");
        display("---------");
        display(lottoStore.displayLottoStatistics(winLotto));
    }
}
