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
    validate(generated);
    this.values = new ArrayList<>(generated).stream()
        .sorted()
        .collect(Collectors.toList());
  }

  public LotteryNumbers(List<Integer> numbers) {
    List<LotteryNumber> generated = numbers.stream()
        .map(LotteryNumber::new)
        .sorted()
        .collect(Collectors.toList());
    validate(generated);
    this.values = generated;
  }

  public List<LotteryNumber> toList() {
    return values;
  }

  public boolean contains(LotteryNumber lotteryNumber) {
    return values.contains(lotteryNumber);
  }

  public WinningLottery rank(LotteryNumbers winning) {
    if (winning.size() != values.size()) {
      return WinningLottery.of(WinningLottery.NONE.matchedCount());
    }

    int matchedCount = (int) values.stream()
        .filter(winning::contains)
        .count();

    return WinningLottery.of(matchedCount);
  }

  public int size() {
    return values.size();
  }

  private void validate(List<LotteryNumber> lotteryNumbers) {
    if (lotteryNumbers.size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException(WRONG_SIZE_EXCEPTION);
    }

    if (new HashSet<>(lotteryNumbers).size() != LOTTERY_NUMBERS_SIZE) {
      throw new IllegalArgumentException(DUPLICATED_EXCEPTION);
    }
  }
}
