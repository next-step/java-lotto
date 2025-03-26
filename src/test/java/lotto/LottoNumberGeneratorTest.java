package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

  @Test
  void 로또번호_생성() {
    List<Integer> numbers = LottoNumberGenerator.getInstance().generate();
    assertThat(numbers.size()).isEqualTo(6);
  }
}