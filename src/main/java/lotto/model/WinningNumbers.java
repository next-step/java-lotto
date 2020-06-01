package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {

  private final LottoNumbers numbers;

  public WinningNumbers(LottoNumbers numbers) {
    this.numbers = numbers;
  }

  public static WinningNumbers newInstanceByStrArr(String[] numberArr) {
    List<Integer> numberList = Stream.of(numberArr).mapToInt(Integer::parseInt).boxed()
        .collect(Collectors.toList());

    return new WinningNumbers(new LottoNumbers(numberList));
  }

  public LottoNumbers getNumbers() {
    return numbers;
  }

  public PrizeTier getPrizeTier(LottoNumbers numbers) {
    int matchCnt = 0;

    for (Integer number : numbers.values()) {
      matchCnt += isMatchedToWinningNumber(number) ? 1 : 0;
    }

    return PrizeTierMapper.INSTANCE.getPrizeTierByMatchCnt(matchCnt);
  }

  private boolean isMatchedToWinningNumber(Integer number) {
    return this.numbers.values().contains(number);
  }
}
