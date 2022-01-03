package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbersGenerator {

  private static final List<LotteryNumber> LOTTERY_NUMBERS = init();
  private static final int START_INDEX = 0;

  private static List<LotteryNumber> init() {
    List<LotteryNumber> lotteryNumbers = IntStream
        .range(LotteryNumber.minNumber(), LotteryNumber.maxNumber())
        .mapToObj(LotteryNumber::new)
        .collect(Collectors.toList());

    return Collections.unmodifiableList(lotteryNumbers);
  }

  public static List<LotteryNumber> generate(int size) {
    List<LotteryNumber> lotteryNumbers = shuffle();
    return lotteryNumbers.subList(START_INDEX, size);
  }

  private static List<LotteryNumber> shuffle() {
    List<LotteryNumber> lotteryNumbers = new ArrayList<>(LOTTERY_NUMBERS);
    Collections.shuffle(lotteryNumbers);
    return lotteryNumbers;
  }
}
