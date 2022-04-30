package lotto.domain.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FixedNumberGeneratorTest {

  @ParameterizedTest
  @DisplayName("고정된 번호로 잘 생성되는지 확인")
  @ValueSource(strings = {"1,10", "10,20", "100,400,0"})
  void generate(String numbers) {
    FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(numbers);
    String[] numberSplitted = numbers.split(",");
    List<Integer> generated = fixedNumberGenerator.generate();

    for (int i = 0; i < numberSplitted.length; i++) {
      assertThat(generated.get(i)).isEqualTo(Integer.valueOf(numberSplitted[i]));
    }

  }
}