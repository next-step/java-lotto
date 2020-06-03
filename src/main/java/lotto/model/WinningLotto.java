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
    List<Integer> numberList = Stream.of(numberArr)
        .mapToInt(num -> Integer.parseInt(num.trim()))
        .boxed()
        .collect(Collectors.toList());

    return new WinningLotto(new Lotto(numberList));
  }

  public Lotto getLotto() {
    return lotto;
  }

  public PrizeTier getPrizeTier(Lotto target) {
    return PrizeTierMapper.INSTANCE.getPrizeTierByMatchCnt(this.lotto.numberOfMatchesTo(target));
  }
}
