package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {

  private final Lotto lotto;

  public WinningLotto(Lotto lotto) {
    this.lotto = lotto;
  }

  public static WinningLotto newInstanceByStrArr(String[] numberArr) {
    List<LottoNumber> numberList = Stream.of(numberArr)
        .map(num -> new LottoNumber(Integer.parseInt(num.trim()), false))
//            .boxed()
            .collect(Collectors.toList());

    return new WinningLotto(new Lotto(numberList));
  }

  public Lotto getLotto() {
    return lotto;
  }

  public PrizeTier getPrizeTier(Lotto target) {
    return PrizeTierMapper.getInstance()
        .getPrizeTierByMatchCnt(this.lotto.numberOfMatchesTo(target));
  }
}
