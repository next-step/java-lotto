package lotto;

import lotto.application.strategy.RandomGenerator;
import lotto.domain.Lotto;
import lotto.application.LottoProgram;
import lotto.domain.LottoPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInterface {
    public void start() {
        LottoPrice lottoAmountPurchased = new LottoPrice(InputView.getLottoPricePurchased());

        int manualLottoQuantity = InputView.getManualLottoQuantityPurchased();
        int lottoQuantityWithoutManual = lottoAmountPurchased.countLottoQuantity() - manualLottoQuantity;

        List<String[]> manualLottosInput = InputView.getManualLottos(manualLottoQuantity);
        validateInputManualLottos(manualLottosInput, manualLottoQuantity);

        OutputView.printLottoQuantityPurchased(manualLottoQuantity, lottoQuantityWithoutManual);

        LottoProgram lottoProgram = new LottoProgram(new RandomGenerator());

        List<Lotto> totalLottos = lottoProgram.generateLottos(lottoQuantityWithoutManual, manualLottosInput);
        OutputView.printLottos(totalLottos);

        String[] lastWinningLottoNumbersInput = InputView.getLastWinningLottoNumbers();
        int bonusBall = InputView.getBonusBallFromUser();

        OutputView.printWinningStatistics(
                lottoAmountPurchased,
                lottoProgram.createWinningStatistics(totalLottos, lastWinningLottoNumbersInput, bonusBall));
    }

    private static void validateInputManualLottos(List<String[]> manualLottos, int manualLottoQuantity) {
        if (manualLottoQuantity != manualLottos.size()) {
            throw new IllegalArgumentException("수동으로 구매한 로또 수만큼만 로또를 입력해주세요");
        }
    }

    public static void main(String[] args) {
        LottoInterface lottoInterface = new LottoInterface();
        lottoInterface.start();
    }

}
