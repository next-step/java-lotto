package lotto.generator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GenerateStrategyManualTest {

  @Test
  void 입력된_번호로_로또_생성() {
    final GenerateStrategy generator = new GenerateStrategyManual(
            "1,2,3,4,5,6"
    );

    Lotto lotto = generator.generate();
    assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
  }

  @Test
  void 번호_범위를_넘어가면_예외() {
    final GenerateStrategy generator = new GenerateStrategyManual(
            "1,2,3,4,5,50"
    );
    assertThatThrownBy(generator::generate)
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 번호_개수가_틀리면_예외() {
    final GenerateStrategy generator = new GenerateStrategyManual(
            "1,2,3,4,5"
    );

    assertThatThrownBy(generator::generate)
            .isInstanceOf(IllegalArgumentException.class);
  }
}
