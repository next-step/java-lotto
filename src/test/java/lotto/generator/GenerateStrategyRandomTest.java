package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoBall;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GenerateStrategyRandomTest {
  @Test
  void 생성된_번호로_로또_생성() {
    GenerateStrategy generator = new GenerateStrategyRandom() {
      @Override
      protected List<LottoBall> nonDuplicatedRandomNumbers(final int size) {
        return List.of(
                LottoBall.of(1),
                LottoBall.of(2),
                LottoBall.of(3),
                LottoBall.of(4),
                LottoBall.of(5),
                LottoBall.of(6)
        );
      }
    };

    Lotto lotto = generator.generate();
    assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
  }
}
