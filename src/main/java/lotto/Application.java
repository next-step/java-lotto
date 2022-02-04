package lotto;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.service.LottoAutoGenerator;
import lotto.service.LottoCountCalculator;
import lotto.view.LottoInput;

public class Application {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int buyPrice = LottoInput.inputPrice();
        int buySum = buyPrice / LOTTO_PRICE;

        List<LottoNumbers> userLottoNumbers = LottoAutoGenerator.getInstance().generateLottos(buySum);
        LottoNumbers lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();

        List<Ranking> rankings = LottoCountCalculator.getInstance().countLotteryNumbers(userLottoNumbers, lastWeekLottoNumber, bonusNumber);
    }
}
