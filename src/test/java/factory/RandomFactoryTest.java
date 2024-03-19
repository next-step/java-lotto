package factory;

import domain.PositiveNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RandomFactoryTest {
  @ParameterizedTest
  @CsvSource({ "1,1", "3,3", "5,5" })
  void 입력_n_만큼의_숫자_생성(int size, int expected) {
    assertThat(RandomFactory.randomNumbers(PositiveNumber.of(size)).size()).isEqualTo(expected);
  }
}
