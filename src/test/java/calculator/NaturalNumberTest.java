package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NaturalNumberTest {

  @ParameterizedTest(name = "자연수 파싱 테스트 : {0}")
  @ValueSource(strings = {"0", "1", "2", "10"})
  void parseTest(String input) {
    //when
    int naturalNumber = NaturalNumber.parseNaturalNumber(input);

    //then
    assertThat(naturalNumber).isEqualTo(Integer.parseInt(input));
  }

  @ParameterizedTest(name = "잘못된 자연수 파싱 테스트 : {0}")
  @ValueSource(strings = {"-1", "-2", "-100"})
  void invalidParseTest(String input) {
    assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
      NaturalNumber.parseNaturalNumber(input);
    });
  }
}
