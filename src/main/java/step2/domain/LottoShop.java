package step2.domain;

import step2.exception.LottoGamePriceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoShop {

  public static final long LOTTO_PRICE = 1000;

  private final List<Lotto> lottoList;
  private final long price;

  private LottoShop(List<Lotto> lottoList) {
    this.lottoList = lottoList;
    this.price = lottoList.size() * LOTTO_PRICE;
  }

  public long getPrice() {
    return price;
  }

  public Stream<Lotto> stream () {
    return lottoList.stream();
  }

  public static LottoShop of (long price) {
    validatePrice(price);
    int lottoCount = (int)(price / LOTTO_PRICE);
    return Arrays.stream(new long[lottoCount])
                 .boxed()
                 .map(v -> Lotto.of())
                 .collect(collectingAndThen(toList(), LottoShop::of));
  }

  public static LottoShop of (List<Lotto> lottoList) {
    return new LottoShop(lottoList);
  }

  public static void validatePrice (long price) throws RuntimeException {
    if (price < LOTTO_PRICE) {
      throw new LottoGamePriceException();
    }
  }
}
