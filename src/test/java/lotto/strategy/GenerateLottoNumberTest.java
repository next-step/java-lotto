package lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GenerateLottoNumberTest {

  @DisplayName("로또번호 6개 생성 테스트.")
  @Test
  void 로또번호리스트생성() {
    GenerateValues generateValues = new GenerateLottoNumber();
    assertThat(generateValues.createNumberPull().size()).isEqualTo(6);
  }

  @DisplayName("생성되는 번호 중 중복이 있는지 테스트.")
  @Test
  void 중복된번호가주입되는지여부() {
    GenerateValues generateValues = new GenerateLottoNumber();
    Set<Integer> duplicateCheck = new HashSet<>(generateValues.createNumberPull());
    assertThat(duplicateCheck.size()).isEqualTo(6);
  }
}