package lotto.domain.round;

import java.util.Set;
import lotto.domain.game.LottoWinType;

public class LottoRoundJudge {

  public LottoWinType judge (Set<Integer> numbers, Set<Integer> winningNumbers) {
    final int matchingNumberCnt = (int) numbers.stream()
        .filter(winningNumbers::contains)
        .count();

    return LottoWinType.findByMatchingNumberCnt(matchingNumberCnt);
  }
}
