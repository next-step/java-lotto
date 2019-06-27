package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockNumberGenerator implements NumberGenerator {

  @Override
  public List<LottoNumber> generate(int limit) {
    return IntStream.rangeClosed(1, limit).boxed().map(LottoNumber::new).collect(Collectors.toList());
  }
}
