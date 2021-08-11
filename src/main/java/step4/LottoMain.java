package step4;

import step4.util.LottoManualNumberGenerator;
import step4.util.LottoRandomNumberGenerator;
import step4.view.LottoInputView;
import step4.view.LottoResultView;

import java.util.List;

public class LottoMain {
    private static final int LOTTO_UNIT_PRICE = 1000;

    public static void main(String[] args) {
        LottoPrice lottoPrice = new LottoPrice(LOTTO_UNIT_PRICE);

        int budget = LottoInputView.getIntegerWithMessage("구입금액을 입력해 주세요.");

        int numberOfManual = LottoInputView.getIntegerWithMessage("수동으로 구매할 로또 수를 입력해 주세요.");

        List<List<Integer>> manualNumbersList = LottoInputView.getManualLottoNumbersWithPrompt(numberOfManual, "수동으로 구매할 번호를 입력해 주세요.");

        LottoBucket manualLottoBucket = LottoStore.buyLottoEntries(numberOfManual, new LottoManualNumberGenerator(manualNumbersList));
        LottoBucket autoLottoBucket = LottoStore.buyLottoEntries(lottoPrice.getMaxQuantity(budget), new LottoRandomNumberGenerator());

        LottoResultView.printLottoQuantity(manualLottoBucket, autoLottoBucket);
        LottoResultView.printAllLottoEntries(manualLottoBucket, autoLottoBucket);

        List<Integer> numbers = LottoInputView.getLastDrawNumbersWithPrompt("지난 주 당첨 번호를 입력해 주세요.");

        int bonusNumber = LottoInputView.getIntegerWithMessage("보너스 볼을 입력해 주세요.");

        DrawnLotto drawnLotto = new DrawnLotto(numbers, bonusNumber);

        LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottoPrice, drawnLotto);

        lottoWinStatistics.addLottoSamples(manualLottoBucket);
        lottoWinStatistics.addLottoSamples(autoLottoBucket);

        LottoResultView.printLottoWinStatus(lottoWinStatistics);
        LottoResultView.printProfitRate(lottoWinStatistics);
    }
}
