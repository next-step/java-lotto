import lotto.domain.*;
import lotto.factory.LottoFactory;
import lotto.factory.RandomFactory;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.view.InputView.*;

public class Main {
  private static final LottoFactory lottoFactory = new LottoFactory(new RandomFactory(new Random()));

  public static void main(String[] args) {

    PositiveNumber amountTotal = PositiveNumber.of(InputView.inputTotalAmount());
    PositiveNumber countTotal = Lotto.count(amountTotal);
    PositiveNumber countManual = PositiveNumber.of(inputCountManual());
    PositiveNumber countRandom = countTotal.subtract(countManual);

    Lottos lottos = lottoFactory.manualLottos(parseBallNumbersList(inputManualLottoNumbers(countManual)));
    lottos.addAll(lottoFactory.randomLottos(countRandom));

    ResultView.lottoCount(countManual, countRandom);
    ResultView.lottoList(lottos);

    ResultView.stats(lottos.results(lottery()));
  }

  private static List<String[]> parseBallNumbersList(String[] lottoBallLines) {
    return Arrays.stream(lottoBallLines)
            .map(Main::parseBallNumberArray)
            .collect(Collectors.toList());
  }

  private static String[] parseBallNumberArray(String ballNumbers) {
    return ballNumbers.replace(" ", "").split(",");
  }
}
