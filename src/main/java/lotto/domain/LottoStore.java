package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

  public static List<LottoNumbers> generateAutoLottos(Amount amount) {
    return IntStream.range(0, amount.getAutoAmount())
        .mapToObj(i -> new LottoNumbers())
        .collect(Collectors.toList());
  }
}
