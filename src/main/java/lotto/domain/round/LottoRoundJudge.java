package lotto.domain.round;

import java.util.List;
import lotto.domain.game.LottoWinType;
import lotto.domain.game.LottoWinningNumber;

public class LottoRoundJudge {

  public LottoWinType judge (LottoRoundNumbers roundNumbers, LottoWinningNumber winningNumber) {
    final List<Integer> numbers = roundNumbers.getNumbers();

    final int matchingNumberCnt = (int) numbers.stream()
        .filter(winningNumber::containsWinningNumbers)
        .count();

    final boolean isBonusNumberInclude = numbers.contains(winningNumber.getBonusNumber());

    return LottoWinType.getWinTypeByMatchingCnt(matchingNumberCnt, isBonusNumberInclude);
  }
}
