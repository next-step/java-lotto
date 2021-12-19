package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LotteryNumbersGenerator {

  public static List<LotteryNumber> generate() {
    List<LotteryNumber> lotteryNumbers = new ArrayList<>();
    IntStream
        .range(LotteryNumber.getMinNumber(), LotteryNumber.getMaxNumber())
        .forEach(number -> lotteryNumbers.add(new LotteryNumber(number)));
    return Collections.unmodifiableList(lotteryNumbers);
  }
}
