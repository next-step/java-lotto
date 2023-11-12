package step2;

import step2.domain.LottoNumbers;
import step2.domain.Lottos;
import step2.domain.PrizeLotto;
import step2.domain.WinningStatistics;
import step2.view.InputView;
import step2.view.ResultView;

import java.math.BigDecimal;

import static step2.domain.LottoNumberGenerator.lottoNumbers;
import static step2.domain.LottoStore.lottos;
import static step2.domain.LottoStore.numberOfLotto;
import static step2.util.BigDecimalUtil.stringToBigDecimal;
import static step2.util.StringUtil.numbers;

public class Runner {

    public static void main(String[] args) {
        BigDecimal price = stringToBigDecimal(InputView.price());
        int numberOfLotto = numberOfLotto(price);
        ResultView.printPurchaseMessage(numberOfLotto);

        Lottos lottos = lottos(lottoNumbers(numberOfLotto));
        ResultView.printLottos(lottos);

        LottoNumbers prizeLottoNumbers = new LottoNumbers(numbers(InputView.prizeLottoNumber()));
        int bonusNumber = InputView.bonusNumber();
        PrizeLotto prizeLotto = new PrizeLotto(prizeLottoNumbers, bonusNumber);
        WinningStatistics winningStatistics = WinningStatistics.of(lottos, prizeLotto);
        ResultView.printWinningStatistics(winningStatistics);
        ResultView.printRateOfReturn(price, winningStatistics);
    }

}
