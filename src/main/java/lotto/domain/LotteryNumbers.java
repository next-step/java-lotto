package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryNumbers {

  public static final int LOTTERY_NUMBERS_SIZE = 6;

  private final List<LotteryNumber> lotteryNumbers;

  public LotteryNumbers() {
    List<LotteryNumber> generated = LotteryNumbersGenerator.generate(LOTTERY_NUMBERS_SIZE);
    validate(generated);
    this.lotteryNumbers = new ArrayList<>(generated).stream()
        .sorted()
        .collect(Collectors.toList());
  }

  public LotteryNumbers(List<Integer> numbers) {
    List<LotteryNumber> generated = numbers.stream()
        .map(LotteryNumber::new)
        .sorted()
        .collect(Collectors.toList());
    validate(generated);
    this.lotteryNumbers = generated;
  }

  public List<LotteryNumber> toList() {
    return lotteryNumbers;
  }

  public WinningLottery rank(LotteryNumbers winning) {
    if (winning.size() != lotteryNumbers.size()) {
      return WinningLottery.of(-1);
    }

    int matchedCount = (int) lotteryNumbers.stream()
        .filter(winning.lotteryNumbers::contains)
        .count();

    return WinningLottery.of(matchedCount);
  }

  public int size() {
    return lotteryNumbers.size();
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
