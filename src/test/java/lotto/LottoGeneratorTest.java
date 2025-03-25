package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LottoGeneratorTest {
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

  @DisplayName("랜덤으로 로또번호를 구성하여 로또를 생성하는 기능을 구현한다.")
  @Test
  void testGenerateRandom() {
    Lotto lotto = new RandomLottoGenerator().generate();

    assertEquals(6, lotto.getNumbers().size());

    for (LottoNumber lottoNumber : lotto.getNumbers()) {
      assertTrue(lottoNumber.getValue() >= 1 && lottoNumber.getValue() <= 45);
    }
    assertEquals(6, lotto.getNumbers().stream().distinct().count());
  }
}