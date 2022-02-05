package lotto;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.service.LottoAutoGenerator;
import lotto.service.LottoCountCalculator;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int buyPrice = LottoInput.inputPrice();
        int buySum = countBuySum(buyPrice);

        LottoOutput.printBuySum(buySum);

        List<LottoNumbers> userLottoNumbers = LottoAutoGenerator.getInstance()
            .generateLottos(buySum);

        LottoOutput.printLottoNumber(userLottoNumbers);

        LottoNumbers lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();

        List<Ranking> rankings = LottoCountCalculator.getInstance()
            .countLotteryNumbers(userLottoNumbers, lastWeekLottoNumber, bonusNumber);

        LottoOutput.printRankingStatus(rankings);
        LottoOutput.printRewardRate(rankings, buyPrice);
    }

    private static int countBuySum(int buyPrice) {
        return buyPrice / LOTTO_PRICE;
    }
}
