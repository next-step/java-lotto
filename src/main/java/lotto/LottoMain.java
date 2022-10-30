package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.factory.LottoFactory;
import lotto.strategy.LottoNumbersRandomStrategy;
import lotto.strategy.LottoNumbersStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {

    public static void main(String[] args) {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();

        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        Lottos lottos = LottoFactory.createLottos(strategy, lottoPurchaseAmount);

        ResultView.printLottoAmountAndNumbers(lottos);

        String winningLottoNumbersString = InputView.inputWinningLottoNumbersString();
        LottoNumbers winningLottoNumbers = new LottoNumbers(Stream.of(winningLottoNumbersString.split(","))
                                                                  .map(String::trim)
                                                                  .map(Integer::parseInt)
                                                                  .map(LottoNumber::new)
                                                                  .collect(Collectors.toList()));
        LottoNumber bonusLottoNumber = new LottoNumber(InputView.inputBonusLottoNumber());

        LottoWinningStatistics lottoWinningStatistics = lottos.giveOutWinningStatistics(
                lottoPurchaseAmount, winningLottoNumbers, bonusLottoNumber);
        ResultView.printLottoWinningStatistics(lottoWinningStatistics);
    }
}
