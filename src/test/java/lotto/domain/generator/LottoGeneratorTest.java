package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class LottoGeneratorTest {
  public static class TestLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
      return new Lotto(List.of(
              new LottoNumber(1),
              new LottoNumber(45),
              new LottoNumber(2),
              new LottoNumber(44),
              new LottoNumber(3),
              new LottoNumber(43)
      ));
    }
  }
}