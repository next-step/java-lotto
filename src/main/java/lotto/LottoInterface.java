package lotto;

import lotto.application.strategy.RandomGenerator;
import lotto.domain.Lotto;
import lotto.application.LottoProgram;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoInterface {
    public void start() {
        LottoPrice lottoAmountPurchased = new LottoPrice(InputView.getLottoPricePurchased());

        int lottoQuantityPurchased = lottoAmountPurchased.countLottoPurchased();
        OutputView.printLottoQuantityPurchased(lottoQuantityPurchased);

        LottoProgram lottoProgram = new LottoProgram(new RandomGenerator());
        List<Lotto> lottos = lottoProgram.generateLottos(lottoQuantityPurchased);
        OutputView.printLottos(lottos);

        String[] lastWinningLottoNumberInput = InputView.getLastWinningLottoNumbers();
        int bonusBall = InputView.getBonusBallFromUser();

        OutputView.printWinningStatistics(
                lottoAmountPurchased,
                lottoProgram.createWinningStatistics(lottos, lastWinningLottoNumberInput, new LottoNumber(bonusBall)));
    }

    public static void main(String[] args) {
        LottoInterface lottoInterface = new LottoInterface();
        lottoInterface.start();
    }

}
