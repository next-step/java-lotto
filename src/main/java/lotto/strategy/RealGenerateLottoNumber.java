package lotto.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class RealGenerateLottoNumber implements GenerateLottoNumber{

  private static final int START = 1;

  private static final int END = 46;

  public RealGenerateLottoNumber() {
  }

  @Override
  public List<LottoNumber> createNumberPull() {
    return IntStream.range(START, END)
        .mapToObj(i -> new LottoNumber(i)).collect(Collectors.toList());
  }
}
