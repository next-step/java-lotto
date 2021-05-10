package study.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottosFactory {

  public static Lottos makeLottos(int lottoCount) {
    List<Lotto> lottoList = IntStream.range(0, lottoCount)
        .mapToObj(i -> LottoNumber.pick())
        .map(Lotto::new)
        .collect(Collectors.toList());

    return new Lottos(lottoList);
  }

}
