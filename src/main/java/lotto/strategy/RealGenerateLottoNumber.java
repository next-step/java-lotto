package lotto.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class RealGenerateLottoNumber implements GenerateLottoNumber{

  private int startIndex;

  private int endIndex;

  public RealGenerateLottoNumber(int start, int end) {
    this.startIndex = start;
    this.endIndex = end;
  }

  @Override
  public List<LottoNumber> createNumberPull() {
    return IntStream.range(startIndex, endIndex)
        .mapToObj(i -> new LottoNumber(i)).collect(Collectors.toList());
  }
}
