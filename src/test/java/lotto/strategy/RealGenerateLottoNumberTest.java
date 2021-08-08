package lotto.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealGenerateLottoNumberTest {

  @DisplayName("로또번호 6개 생성 테스트.")
  @Test
  void 로또번호리스트생성() {

    assertThat(GenerateLottoNumber.createNumberPull().size()).isEqualTo(6);
  }

  @DisplayName("생성되는 번호 중 중복이 있는지 테스트.")
  @Test
  void 중복된번호가주입되는지여부() {
    Set<Integer> duplicateCheck = new HashSet<>();

    duplicateCheck.addAll(GenerateLottoNumber.createNumberPull());
    assertThat(duplicateCheck.size()).isEqualTo(6);
  }
}