package lotto.step4.domain;

import lotto.step4.execption.LottoLesserPriceException;
import lotto.step4.execption.LottoMinimumPriceException;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoShop {

  private LottoShop() {}

  public static Lottos buyLotto (long price, List<Lotto> lottos) {
    validateMinimumPrice(price);
    final long lesserPrice = price - lottos.size() * Lotto.PRICE;
    validateLesserPrice(lesserPrice);
    lottos.addAll(provideAutoLottos(lesserPrice));
    return Lottos.of(lottos);
  }

  private static List<Lotto> provideAutoLottos (long price) {
    return Stream.generate(LottoGenerator::generateLotto)
                 .limit(price / Lotto.PRICE)
                 .collect(toList());
  }

  public static void validateMinimumPrice (long price) throws RuntimeException {
    if (price < Lotto.PRICE) {
      throw new LottoMinimumPriceException();
    }
  }

  public static void validateLesserPrice (long price) throws RuntimeException {
    if (price < 0) {
      throw new LottoLesserPriceException();
    }
  }

}
