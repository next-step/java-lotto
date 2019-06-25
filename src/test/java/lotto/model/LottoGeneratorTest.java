package lotto.model;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.MockNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoGeneratorTest {

  @ParameterizedTest
  @ValueSource(ints = {15000, 15010})
  @DisplayName("로또 생성")
  void generate(int paid) {
    Lottos lottos = new LottoGenerator(new MockNumberGenerator()).generate(paid);
    assertThat(lottos.getCount()).isEqualTo(15);
  }
}
