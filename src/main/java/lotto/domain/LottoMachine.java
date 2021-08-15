package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.strategy.GenerateLottoNumber;
import lotto.strategy.GenerateStringToIntNumber;
import lotto.strategy.GenerateValues;

public class LottoMachine {

  private static final int START_INCLUSIVE = 0;

  public static Lotteries createLottos(final int totalLottoNumber,
      final List<String> manualLottoNumber) {

    return new Lotteries(IntStream.range(START_INCLUSIVE, totalLottoNumber)
        .mapToObj(count -> createLotto(count, manualLottoNumber))
        .collect(Collectors.toList()));
  }

  private static Lotto createLotto(final int count, final List<String> manualLottoNumber) {

    GenerateValues generateValues;

    if(count < manualLottoNumber.size()){
      generateValues = new GenerateStringToIntNumber(manualLottoNumber.get(count));
      return new Lotto(generateValues.createNumberPull());
    }

    generateValues = new GenerateLottoNumber();
    return new Lotto(generateValues.createNumberPull());
  }
}
