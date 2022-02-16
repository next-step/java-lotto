package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Rankings;
import lotto.domain.WinningLotto;
import lotto.service.LottoAutoGenerator;
import lotto.service.LottoRankingCalculator;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int buyPrice = LottoInput.inputPrice();
        int buySum = countBuySum(buyPrice);

        LottoOutput.printBuySum(buySum);

        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> userLottoNumbers = lottoAutoGenerator.generateLottos(buySum);

        LottoOutput.printLottoNumber(userLottoNumbers);

        Lotto lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();
        WinningLotto winningLotto = new WinningLotto(lastWeekLottoNumber, bonusNumber);

        Rankings rankings = LottoRankingCalculator.getInstance()
            .countLotteryNumbers(userLottoNumbers, winningLotto);

        LottoOutput.printRankingStatus(rankings);
        LottoOutput.printRewardRate(rankings, buyPrice);
    }

    private static int countBuySum(int buyPrice) {
        return BigDecimal.valueOf(buyPrice).divide(BigDecimal.valueOf(LOTTO_PRICE), RoundingMode.DOWN).intValue();
    }
}
