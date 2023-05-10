package lotto;

import static lotto.LottoNumberGenerator.LOTTO_NUMBER_COUNT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {

  private final Set<Integer> winningNumbers;

  public WinningNumbers(String input) {
    this.winningNumbers = new HashSet<>();
    this.winningNumbers.addAll(Arrays.asList(toIntegers(split(input))));
    if (isLottoNumberCountEqualTo(winningNumbers.size())) {
      throw new IllegalArgumentException("당첨 번호는 중복되지 않은 숫자로 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }
  }

  public int findHowManyMatches(Lotto lotto) {
    int matchesNumber = 0;
    for (Integer winningNumber : winningNumbers) {
      matchesNumber = lotto.has(winningNumber) ? matchesNumber + 1 : matchesNumber;
    }
    return matchesNumber;
  }

  private Integer[] toIntegers(String[] tokens) {
    if (isLottoNumberCountEqualTo(tokens.length)) {
      throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBER_COUNT + "개여야합니다.");
    }

    Integer[] integers = new Integer[LOTTO_NUMBER_COUNT];
    for (int i = 0; i < tokens.length; i++) {
      integers[i] = Integer.parseInt(tokens[i]);
    }
    return integers;
  }

  private boolean isLottoNumberCountEqualTo(int length) {
    return length != LOTTO_NUMBER_COUNT;
  }

  private String[] split(String carsName) {
    return carsName.replace(" ", "").split(",");
  }

}
