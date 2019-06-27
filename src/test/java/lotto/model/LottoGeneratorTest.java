package lotto.model;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.MockNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoGeneratorTest {

  @Test
  @DisplayName("로또 생성")
  void generate() {
    Money paidMoney = new Money(15000);
    Lottos lottos = new LottoGenerator(new MockNumberGenerator()).generate(paidMoney);
    assertThat(lottos.getCount()).isEqualTo(15);
  }

  @Test
  @DisplayName("로또 생성2 generate에 List<Integer> 넘기는 방식")
  void generate2() {
    Lotto lotto = LottoGenerator.generate(Arrays.asList(1, 2, 3, 4, 5, 6));
    assertThat(lotto.contains(1)).isTrue();
  }
}
