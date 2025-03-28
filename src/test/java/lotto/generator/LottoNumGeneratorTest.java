package lotto.generator;

import lotto.type.LottoNums;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumGeneratorTest {

  @DisplayName("로또 숫자 생성 테스트")
  @Test
  void testGenerate() {
    LottoNumGenerator generator = new LottoNumGenerator();

    LottoNums lottoNums = generator.generate(nums -> nums);

    assertThat(lottoNums).isEqualTo(LottoNums.valueOf(List.of(1, 2, 3, 4, 5, 6)));
  }
}
