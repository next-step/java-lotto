package step2;

import step2.domain.Lotto;
import step2.domain.Lottos;
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

        Lotto prizeLotto = new Lotto(numbers(InputView.prizeLottoNumber()));
        WinningStatistics winningStatistics = lottos.winningStatistics(prizeLotto);
        ResultView.printWinningStatistics(winningStatistics);
    }

}
