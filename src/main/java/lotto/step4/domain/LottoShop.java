package lotto.step4.domain;

import lotto.step4.execption.LottoLesserPriceException;
import lotto.step4.execption.LottoMinimumPriceException;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoShop {

  private LottoShop() {}

  public static Lottos buyLotto (long price) {
    validateMinimumPrice(price);
    return Stream.generate(LottoGenerator::generateLotto)
                 .limit(price / Lotto.PRICE)
                 .collect(collectingAndThen(toList(), Lottos::of));
  }

  public static Lottos buyLotto (long price, List<Lotto> lottosByDirectInput) {
    Lottos lottos = Lottos.of(lottosByDirectInput);
    long lesserPrice = price - lottos.getPrice();
    validateLesserPrice(price);
    return Lottos.concat(lottos, buyLotto(lesserPrice));
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
