package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGeneratorTest {

  @DisplayName("로또가 1 ~ 45 사이의 숫자로 생성되는지 검증")
  @Test
  void 로또_번호_범위_검증 () {
    int expected = 0;
    final BinaryOperator<Integer>
          reducer = (sum, v) -> sum + (v < Lotto.MIN_VALUE || v > Lotto.MAX_VALUE ? 1 : 0);
    for (int i = 0; i < 1000000; i++) {
      assertEquals(expected, LottoGenerator.generateLotto()
                                             .stream()
                                             .reduce(0, reducer));
    }
  }
  @DisplayName("로또가 1 ~ 45 사이의 숫자로 생성되는지 검증")
  @Test
  void 로또_번호_갯수_검증 () {
    long expected = Lotto.SIZE;
    for (int i = 0; i < 1000000; i++) {
      assertEquals(expected, LottoGenerator.generateLotto().stream().count());
    }
  }
}
