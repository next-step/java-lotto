package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

  private final List<Lotto> lottoList;

  private Lottos (int price) {
    this.lottoList = Arrays.stream(new int[price / 1000])
                           .boxed()
                           .map(v -> Lotto.of())
                           .collect(Collectors.toList());
  }

  public static Lottos of (int price) {
    return new Lottos(price);
  }
}
