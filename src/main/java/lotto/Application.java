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

        LottoNumbers userLottoNumber = LottoAutoGenerator.getInstance().generateLotto();
        LottoNumbers lastWeekLottoNumber = LottoInput.inputWinningNumber();
        LottoNumber bonusNumber = LottoInput.inputBonusBall();

        List<LottoNumbers> lottoNumbers = LottoAutoGenerator.getInstance().generateLottos(buySum);

        Ranking ranking = LottoCountCalculator.getInstance().countLotteryNumber(userLottoNumber, lastWeekLottoNumber, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("-----------");
    }
}
