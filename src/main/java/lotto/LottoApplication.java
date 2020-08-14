package lotto;

import java.util.Set;

import lotto.domain.LottoManualSalesStoreBuilder;
import lotto.domain.LottoStore;
import lotto.domain.core.LottoGenerator;
import lotto.domain.core.WinningLotto;
import lotto.ui.LottoUserInput;

import static lotto.domain.core.LottoGenerator.fromIntSet;
import static lotto.ui.LottoDisplay.display;
import static lotto.ui.LottoDisplay.newLine;
import static lotto.ui.LottoUserInput.inputBonusNo;
import static lotto.ui.LottoUserInput.inputManualLottoCount;
import static lotto.ui.LottoUserInput.inputPurchaseAmount;
import static lotto.ui.LottoUserInput.inputWinLotto;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int manualLottoCount = inputManualLottoCount();
        LottoStore lottoStore = inputManualLotto(LottoStore.purchaseManualOrAutoLotto(purchaseAmount, manualLottoCount));
        displayLottoList(lottoStore);
        displayLottoStatistics(lottoStore);
    }

    private static LottoStore inputManualLotto(LottoManualSalesStoreBuilder lottoManualSalesStoreBuilder) {
        display("수동으로 구매할 번호를 입력해 주세요.");
        return lottoManualSalesStoreBuilder.createManualLottoStore(LottoUserInput::inputManualLotto);
    }

    private static void displayLottoList(LottoStore lottoStore) {
        newLine();
        display(String.format("%d개를 구매했습니다.", lottoStore.countOfPurchased()));
        display(lottoStore.displayLottoList());
    }

    private static void displayLottoStatistics(LottoStore lottoStore) {
        Set<Integer> winLottos = inputWinLotto();
        final WinningLotto winningLotto = LottoGenerator.winLotto(fromIntSet(winLottos), inputBonusNo());
        newLine(1);
        display("당첨 통계");
        display("---------");
        display(lottoStore.displayLottoStatistics(winningLotto));
    }
}
