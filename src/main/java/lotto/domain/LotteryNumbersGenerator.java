package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LotteryNumbersGenerator {
  private static final List<LotteryNumber> LOTTERY_NUMBERS = init();

  private static List<LotteryNumber> init() {
    List<LotteryNumber> lotteryNumbers = new ArrayList<>();
    IntStream
        .range(LotteryNumber.getMinNumber(), LotteryNumber.getMaxNumber())
        .forEach(number -> lotteryNumbers.add(new LotteryNumber(number)));
    return Collections.unmodifiableList(lotteryNumbers);
  }

  public static List<LotteryNumber> generate(int size) {
    List<LotteryNumber> lotteryNumbers = shuffle();
    return lotteryNumbers.subList(0, size);
  }

  private static List<LotteryNumber> shuffle() {
    List<LotteryNumber> lotteryNumbers = new ArrayList<>(LOTTERY_NUMBERS);
    Collections.shuffle(lotteryNumbers);
    return lotteryNumbers;
  }
}
