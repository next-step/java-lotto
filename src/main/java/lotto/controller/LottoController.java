package lotto.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.Rankings;
import lotto.domain.WinningLotto;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoController(LottoGenerator lottoAutoGenerator) {
        this.lottoGenerator = lottoAutoGenerator;
    }

    public void run() {
        int buyPrice = LottoInput.inputPrice();
        int buySum = countBuySum(buyPrice);

        LottoOutput.printBuySum(buySum);

        List<Lotto> userLottoNumbers = lottoGenerator.generateLottos(buySum);

        LottoOutput.printLottoNumber(userLottoNumbers);

        WinningLotto winningLotto = createWinningLotto();

        Rankings rankings = Rankings.of(userLottoNumbers, winningLotto);

        LottoOutput.printLottoResult(rankings, buyPrice);
    }

    private int countBuySum(int buyPrice) {
        return BigDecimal.valueOf(buyPrice)
            .divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.DOWN).intValue();
    }

    private WinningLotto createWinningLotto() {
        Lotto lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();
        return new WinningLotto(lastWeekLottoNumber, bonusNumber);
    }
}
