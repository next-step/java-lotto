package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lotto.strategy.GenerateLottoNumber;

public class Lotteries {

  private static final int INT_ZERO = 0;

  private List<Lotto> lottos = new ArrayList<>();

  public Lotteries(int count) {
    lottos = createLotteries(count);
  }

  public Lotteries() {
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  private List<Lotto> createLotteries(int count) {
    return Collections.unmodifiableList(LongStream.range(INT_ZERO, count)
        .mapToObj(limit -> new Lotto(GenerateLottoNumber.createNumberPull()))
        .collect(Collectors.toList()));
  }

}
