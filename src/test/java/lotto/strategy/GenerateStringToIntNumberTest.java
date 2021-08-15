package lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateStringToIntNumberTest {

  @DisplayName("문자열 값을 받아서 특스문자로 자른 뒤 Integer 콜랙션으로 반환 테스트.")
  @Test
  void 문자열을잘라정수형콜랙션반환() {

    GenerateValues generateValues = new GenerateStringToIntNumber("1,2,3,4,5,6");
    assertThat(generateValues.createNumberPull().size()).isEqualTo(6);
    assertThat(generateValues.createNumberPull()).containsExactly(1,2,3,4,5,6);
  }
}