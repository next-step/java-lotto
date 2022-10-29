package lotto;

import lotto.domain.*;
import lotto.factory.LottoFactory;
import lotto.strategy.LottoNumbersRandomStrategy;
import lotto.strategy.LottoNumbersStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMain {

    private static final int LOTTO_AMOUNT = 1000;

    public static void main(String[] args) {
        LottoNumbersStrategy strategy = new LottoNumbersRandomStrategy();

        int lottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
        List<Lotto> lottos = IntStream.rangeClosed(1, lottoPurchaseAmount / LOTTO_AMOUNT)
                                      .mapToObj(order -> LottoFactory.make(strategy))
                                      .collect(Collectors.toList());

        ResultView.printLottoAmountAndNumbers(lottos);

        String winningLottoNumbersString = InputView.inputWinningLottoNumbersString();
        LottoNumbers winningLottoNumbers = new LottoNumbers(Stream.of(winningLottoNumbersString.split(","))
                                                                  .map(String::trim)
                                                                  .map(Integer::parseInt)
                                                                  .map(LottoNumber::new)
                                                                  .collect(Collectors.toList()));

        LottoWinningStatistics lottoWinningStatistics = LottoWinningStatisticsGenerator.giveOut(
                lottoPurchaseAmount, lottos, winningLottoNumbers);
        ResultView.printLottoWinningStatistics(lottoWinningStatistics);
    }
}
