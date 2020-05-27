package lotto.step2.domain;

import lotto.step2.exception.LottoGamePriceException;

import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoShop {

  private LottoShop() {}

  public static Lottos buyLotto (long price) {
    validatePrice(price);
    return Stream.generate(LottoGenerator::generateLotto)
                 .limit(price / Lotto.PRICE)
                 .collect(collectingAndThen(toList(), Lottos::of));
  }

  public static void validatePrice (long price) throws RuntimeException {
    if (price < Lotto.PRICE) {
      throw new LottoGamePriceException();
    }
  }

}
