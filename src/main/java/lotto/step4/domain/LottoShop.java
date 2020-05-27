package lotto.step4.domain;

import lotto.step4.execption.LottoLesserPriceException;
import lotto.step4.execption.LottoMinimumPriceException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoShop {

  private LottoShop() {}

  public static Lottos buyLotto (long price) {
    validateMinimumPrice(price);
    return Lottos.of(Stream.generate(LottoGenerator::generateLotto)
                           .limit(price / Lotto.PRICE)
                           .collect(toList()),
                     new ArrayList<>());
  }

  public static Lottos buyLotto (long price, List<Lotto> directLottos) {
    validateMinimumPrice(price);
    final long lesserPrice = price - directLottos.size() * Lotto.PRICE;
    validateLesserPrice(lesserPrice);
    List<Lotto> autoLottos = Stream.generate(LottoGenerator::generateLotto)
                                   .limit(lesserPrice / Lotto.PRICE)
                                   .collect(toList());
    return Lottos.of(autoLottos, directLottos);
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
