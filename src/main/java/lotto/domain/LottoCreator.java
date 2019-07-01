package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoTicket.LOTTO_NUMBER_SIZE;

public class LottoCreator {

  private static final int LOTTO_RANGE_START = 1;
  private static final int LOTTO_RANGE_END = 45;
  private static final int START_INDEX = 0;
  private static List<Integer> numberRange;

  public LottoCreator() {
    numberRange = IntStream.rangeClosed(LOTTO_RANGE_START, LOTTO_RANGE_END)
        .boxed()
        .collect(toList());
  }

  public LottoTicket create() {
    Collections.shuffle(numberRange);
    return new LottoTicket(getLottoNumber());
  }

  private LottoNumbers getLottoNumber() {
    return LottoNumbers.of(numberRange.subList(START_INDEX, LOTTO_NUMBER_SIZE));
  }
}