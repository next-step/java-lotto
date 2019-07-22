import lotto.LottoFactory;
import lotto.LottoMoney;
import lotto.LottoResult;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int totalLottoAmount = InputView.getLottoAmounts();

        LottoMoney lottoMoney = LottoMoney.of(totalLottoAmount);

        LottoFactory lottoFactory = new LottoFactory(lottoMoney);
        ResultView.printLottoCounts(lottoFactory.getLottoCounts());

        List<LottoNumbers> lottoNumbersBundle = lottoFactory.createLottoNumbersBundle();
        ResultView.printLottoNumbersBundle(lottoNumbersBundle);

        LottoNumbers winnerLottoNumbers = LottoNumbers.from(InputView.getLotteryNumbersString());
        LottoNumber bonusLottoNumber = LottoNumber.of(InputView.getBonusLottoNumberString());

        LottoResult lottoResult = new LottoResult(winnerLottoNumbers, bonusLottoNumber, lottoNumbersBundle);
        ResultView.printLottoResults(lottoResult);
    }
}
