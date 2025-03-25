package lotto.generator;

import lotto.type.LottoNumList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class LottoNumGeneratorTest {

  @DisplayName("생성자 테스트")
  @Test
  void testConstructor() {
    assertDoesNotThrow(() -> new LottoNumGenerator(6, 45));
  }

  @DisplayName("로또 숫자 생성 테스트")
  @Test
  void testGenerate() {
    LottoNumGenerator generator = new LottoNumGenerator(6, 45);

    LottoNumList lottoNumList = generator.generate(nums -> nums);

    assertThat(lottoNumList).isEqualTo(LottoNumList.valueOf(List.of(1, 2, 3, 4, 5, 6)));
  }
}
