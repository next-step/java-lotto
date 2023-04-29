package lotto.domain.round;

import java.util.List;
import lotto.domain.game.LottoWinType;

public class LottoRoundJudge {

  public LottoWinType judge (List<Integer> numbers, List<Integer> winningNumbers) {
    final int matchingNumberCnt = (int) numbers.stream()
        .filter(winningNumbers::contains)
        .count();

    return LottoWinType.findByMatchingNumberCnt(matchingNumberCnt);
  }
}
