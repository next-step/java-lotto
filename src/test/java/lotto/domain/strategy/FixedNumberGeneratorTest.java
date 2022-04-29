package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FixedNumberGeneratorTest {

  @ParameterizedTest
  @DisplayName("고정된 번호로 잘 생성되는지 확인")
  @ValueSource(ints = {1, 10, 100})
  void generate(int value) {
    FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(value);

    assertThat(fixedNumberGenerator.generate()).isEqualTo(value);
  }
}