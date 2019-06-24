package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoCreator {

  private static final List<Integer> numberRange;

  static {
    numberRange = IntStream.rangeClosed(1, 45)
        .boxed()
        .collect(toList());
  }

  public static LottoTicket create() {
    Collections.shuffle(numberRange);
    return new LottoTicket(numberRange.subList(0, 6));
  }
}
