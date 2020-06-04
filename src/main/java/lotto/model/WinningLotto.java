package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {

  private final Lotto lotto;
  private final LottoNumber bonusNumber;

  public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
    this.lotto = lotto;
    this.bonusNumber = bonusNumber;
  }

  public static WinningLotto newInstanceByStrArr(String[] numberArr, LottoNumber bonusNumber) {
    List<LottoNumber> numberList = Stream.of(numberArr)
        .map(num -> new LottoNumber(Integer.parseInt(num.trim()), false))
        .collect(Collectors.toList());

    return new WinningLotto(new Lotto(numberList), bonusNumber);
  }

  public Lotto getLotto() {
    return lotto;
  }

  public PrizeTier getPrizeTier(Lotto target) {
    int numberOfMatches = lotto.numberOfMatchesTo(target);
    
    return PrizeTier.valueOf(new MatchCnt(lotto.numberOfMatchesTo(target),
        numberOfMatches == 5 && target.has(bonusNumber)));
  }
}
