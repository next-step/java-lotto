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

  private final Set<LotteryNumber> lotteryNumbers;

  public LotteryNumbers() {
    this(LotteryNumbersGenerator.generate(LOTTERY_NUMBERS_SIZE));
  }

  public LotteryNumbers(List<LotteryNumber> lotteryNumbers) {
    validate(lotteryNumbers);
    this.lotteryNumbers = new HashSet<>(lotteryNumbers);
  }

  public static LotteryNumbers of(int[] numbers) {
    List<LotteryNumber> lotteryNumbers = Arrays.stream(numbers)
        .mapToObj(LotteryNumber::new)
        .collect(Collectors.toList());

    return new LotteryNumbers(lotteryNumbers);
  }

  public Set<LotteryNumber> getLotteryNumbers() {
    return Collections.unmodifiableSet(lotteryNumbers);
  }

  private void validate(List<LotteryNumber> lotteryNumbers) {
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
