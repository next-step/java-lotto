package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NumberGeneratorTest {

  @Test
  void randomNumberGenerate() {
    List<LottoNumber> numbers = new RandomNumberGenerator().generate(Lotto.COUNT_OF_NUMBERS);
    assertThat(numbers.size()).isEqualTo(Lotto.COUNT_OF_NUMBERS);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6})
  void mockNumberGenerate(int value) {
    List<LottoNumber> numbers = new MockNumberGenerator().generate(Lotto.COUNT_OF_NUMBERS);
    assertThat(numbers).contains(new LottoNumber(value));
  }
}
