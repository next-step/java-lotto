package lotto;

import java.util.Set;
import java.util.function.Consumer;

import lotto.domain.LottoManualSalesStoreBuilder;
import lotto.domain.LottoStore;
import lotto.domain.core.LottoGenerator;
import lotto.domain.core.WinningLotto;
import lotto.ui.LottoUserInput;

import static lotto.domain.LottoStore.purchaseManualOrAutoLotto;
import static lotto.domain.core.LottoGenerator.fromIntSet;
import static lotto.ui.LottoDisplay.display;
import static lotto.ui.LottoDisplay.newLine;
import static lotto.ui.LottoUserInput.inputBonusNo;
import static lotto.ui.LottoUserInput.inputWinLotto;

final class BuyingLottoUserInterface {
    private int purchaseAmount;
    private int manualLottoCount;
    private LottoStore lottoStore;
    private Exception userInputException;

    static BuyingLottoUserInterface entryPoint() {
        return new BuyingLottoUserInterface();
    }

    BuyingLottoUserInterface inputPurchaseAmount() {
        try {
            purchaseAmount = LottoUserInput.inputPurchaseAmount();
        } catch (Exception e){
            userInputException = e;
        }
        return this;
    }

    BuyingLottoUserInterface inputManualLottoCount() {
        try {
            manualLottoCount = LottoUserInput.inputManualLottoCount();
        }catch (Exception e){
            userInputException = e;
        }
        return this;
    }

    BuyingLottoUserInterface inputManualLottos(){
        try {
            lottoStore = inputManualLottos(purchaseManualOrAutoLotto(purchaseAmount, manualLottoCount));
        }catch (Exception e){
            userInputException = e;
        }
        return this;
    }

    BuyingLottoUserInterface displayLottoStoreInformation(){
        try {
            displayLottoList(lottoStore);
            displayLottoStatistics(lottoStore);
        }catch (Exception e){
            userInputException = e;
        }
        return this;
    }

    void orUserInputErrorDisplay(Consumer<? super Exception> c){
        if (null != userInputException) {
            c.accept(userInputException);
        }
    }

    private static LottoStore inputManualLottos(LottoManualSalesStoreBuilder lottoManualSalesStoreBuilder) {
        display("수동으로 구매할 번호를 입력해 주세요.");
        return lottoManualSalesStoreBuilder
            .forEachBuyerInputManualLotto(LottoUserInput::inputManualLotto)
            .createLottoStore()
            ;
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
