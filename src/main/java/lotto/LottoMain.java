package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.LottoWinningStatisticsGenerator;
import lotto.factory.LottoFactory;
import lotto.strategy.LottoNumberRandomStrategy;
import lotto.strategy.LottoNumberStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMain {

    private static final int LOTTO_AMOUNT = 1000;

    public static void main(String[] args) {
        LottoNumberStrategy strategy = new LottoNumberRandomStrategy();

        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        List<Lotto> lottos = IntStream.rangeClosed(1, lottoPurchaseAmount / LOTTO_AMOUNT)
                                      .mapToObj(order -> LottoFactory.make(strategy))
                                      .collect(Collectors.toList());

        ResultView.printLottoAmountAndNumbers(lottos);

        String winningLottoNumbersString = InputView.inputWinningLottoNumbersString();
        List<LottoNumber> LottoWinningNumbers = Stream.of(winningLottoNumbersString.split(","))
                                                      .map(String::trim)
                                                      .map(Integer::parseInt)
                                                      .map(LottoNumber::new)
                                                      .collect(Collectors.toList());
        Lotto winningLotto = new Lotto(LottoWinningNumbers);

        LottoWinningStatistics lottoWinningStatistics = LottoWinningStatisticsGenerator.giveOut(
                lottoPurchaseAmount, lottos, winningLotto);
        ResultView.printLottoWinningStatistics(lottoWinningStatistics);
    }
}
