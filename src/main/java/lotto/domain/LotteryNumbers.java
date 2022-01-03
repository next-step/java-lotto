package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbers {

  public static final int LOTTERY_NUMBERS_SIZE = 6;
  private static final String DUPLICATED_EXCEPTION = "The number of lotteries cannot be duplicated.";
  private static final String WRONG_SIZE_EXCEPTION =
      String.format("The size of lotteries must be %d.", LOTTERY_NUMBERS_SIZE);

  private final List<LotteryNumber> values;

  public LotteryNumbers() {
    List<LotteryNumber> generated = LotteryNumbersGenerator.generate(LOTTERY_NUMBERS_SIZE);
    validateOrThrow(generated);
    this.values = new ArrayList<>(generated).stream()
        .sorted()
        .collect(Collectors.toList());
  }

  public LotteryNumbers(List<Integer> numbers) {
    List<LotteryNumber> generated = numbers.stream()
        .map(LotteryNumber::new)
        .sorted()
        .collect(Collectors.toList());
    validateOrThrow(generated);
    this.values = generated;
  }

  public List<LotteryNumber> toList() {
    return values;
  }

  public int matchCount(LotteryNumbers winning) {
    return (int) values.stream().filter(winning::contains).count();
  }

  public boolean contains(LotteryNumber lotteryNumber) {
    return values.contains(lotteryNumber);
  }

  public int size() {
    return values.size();
  }

  private void validateOrThrow(List<LotteryNumber> lotteryNumbers) {
    if (lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException(WRONG_SIZE_EXCEPTION);
    }

    if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException(DUPLICATED_EXCEPTION);
    }
  }
}
