package lotto.utility;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberMaker {
  private static final List<Integer> NUMBER_UNDER_FORTY_FIVE = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

  public static List<Integer> makeSixLottoNumber() {
    return sortNumber(shuffleNumber(NUMBER_UNDER_FORTY_FIVE).subList(0, 6));
  }

  private static List<Integer> shuffleNumber(List<Integer> numberList) {
    Collections.shuffle(numberList);

    return numberList;
  }

  private static List<Integer> sortNumber(List<Integer> numberList) {
    Collections.sort(numberList);

    return numberList;
  }
}
