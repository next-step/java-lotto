package lotto.generator;

import lotto.type.LottoNumList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumGeneratorTest {

  @DisplayName("로또 번호 생성")
  @Test
  void testGenerate() {
    LottoNumGenerator lottoNumGenerator = candidates -> candidates;
    assertThat(lottoNumGenerator.generate()).isEqualTo(new LottoNumList(List.of(1, 2, 3, 4, 5, 6)));
  }

}
