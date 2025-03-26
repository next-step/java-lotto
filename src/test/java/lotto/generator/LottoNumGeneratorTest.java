package lotto.generator;

import lotto.type.LottoNumList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumGeneratorTest {

  @DisplayName("로또 숫자 생성 테스트")
  @Test
  void testGenerate() {
    LottoNumGenerator generator = new LottoNumGenerator();

    LottoNumList lottoNumList = generator.generate(nums -> nums);

    assertThat(lottoNumList).isEqualTo(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)));
  }
}
