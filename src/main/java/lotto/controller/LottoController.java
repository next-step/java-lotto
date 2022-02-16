package lotto.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rankings;
import lotto.domain.WinningLotto;
import lotto.service.LottoAutoGenerator;
import lotto.service.LottoRankingCalculator;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private final LottoAutoGenerator lottoAutoGenerator;
    private final LottoRankingCalculator lottoRankingCalculator;

    public LottoController(LottoAutoGenerator lottoAutoGenerator,
        LottoRankingCalculator lottoRankingCalculator) {
        this.lottoAutoGenerator = lottoAutoGenerator;
        this.lottoRankingCalculator = lottoRankingCalculator;
    }

    private static int countBuySum(int buyPrice) {
        return BigDecimal.valueOf(buyPrice)
            .divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.DOWN).intValue();
    }

    private static WinningLotto createWinningLotto() {
        Lotto lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();
        return new WinningLotto(lastWeekLottoNumber, bonusNumber);
    }

    public void run() {
        int buyPrice = LottoInput.inputPrice();
        int buySum = countBuySum(buyPrice);

        LottoOutput.printBuySum(buySum);

        List<Lotto> userLottoNumbers = lottoAutoGenerator.generateLottos(buySum);

        LottoOutput.printLottoNumber(userLottoNumbers);

        WinningLotto winningLotto = createWinningLotto();

        Rankings rankings = lottoRankingCalculator.countLotteryNumbers(userLottoNumbers,
            winningLotto);

        LottoOutput.printLottoResult(rankings, buyPrice);
    }
}
