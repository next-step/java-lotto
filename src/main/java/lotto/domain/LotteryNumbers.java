package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumbers {

  public static final int LOTTERY_NUMBERS_SIZE = 6;

  protected final Set<LotteryNumber> lotteryNumbers;

  public LotteryNumbers() {
    List<LotteryNumber> generated = LotteryNumbersGenerator.generate(LOTTERY_NUMBERS_SIZE);
    validate(generated);
    this.lotteryNumbers = new HashSet<>(generated);
  }

  public LotteryNumbers(List<Integer> numbers) {
    validate(numbers);
    this.lotteryNumbers = numbers.stream().map(LotteryNumber::new).collect(Collectors.toSet());
  }

  private static List<LotteryNumber> fromIntegers(List<Integer> numbers) {
    return numbers.stream().map(LotteryNumber::new).collect(Collectors.toList());
  }

  public Set<LotteryNumber> getLotteryNumbers() {
    return Collections.unmodifiableSet(lotteryNumbers);
  }

  public WinningLottery rank(LotteryNumbers winning) {
    if (winning.getLotteryNumbers().size() != lotteryNumbers.size()) {
      return WinningLottery.of(-1);
    }

    int matchedCount = (int) lotteryNumbers.stream()
        .filter(winning.lotteryNumbers::contains)
        .count();

    return WinningLottery.of(matchedCount);
  }

  private void validate(List<?> lotteryNumbers) {
    if (lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException(
          String.format("The size of lotteries must be %d.", LOTTERY_NUMBERS_SIZE)
      );
    }

    if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException("The number of lotteries cannot be duplicated.");
    }
  }
}
