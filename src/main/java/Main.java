import lotto.domain.*;
import lotto.factory.LottoFactory;
import lotto.generator.GenerateStrategyManual;
import lotto.generator.GenerateStrategyRandom;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.view.InputView.*;

public class Main {
  private static final LottoFactory factory = new LottoFactory();

  public static void main(String[] args) {
    PositiveNumber amountTotal = PositiveNumber.of(InputView.inputTotalAmount());
    PositiveNumber countTotal = Lotto.count(amountTotal);
    PositiveNumber countManual = PositiveNumber.of(inputCountManual());
    PositiveNumber countRandom = countTotal.subtract(countManual);

    ResultView.lottoCount(countManual, countRandom);

    String[] numbersList = inputManualLottoNumbers(countManual);
    Lottos lottos = new Lottos(Arrays.stream(numbersList)
            .map(numbers -> factory.generate(new GenerateStrategyManual(numbers)))
            .collect(Collectors.toList()));
    lottos.addAll(IntStream.range(0, countRandom.value())
            .mapToObj(i -> factory.generate(new GenerateStrategyRandom()))
            .collect(Collectors.toList()));

    ResultView.lottoList(lottos);
    ResultView.stats(lottos.results(lottery()));
  }
}
